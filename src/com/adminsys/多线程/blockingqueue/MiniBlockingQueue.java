package com.adminsys.多线程.blockingqueue;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: qiang
 * @Description:
 * @Create: 2020-05-18 09-16
 **/

public class MiniBlockingQueue implements Queue {

    private ReentrantLock reentrantLock = new ReentrantLock();

    /**
     * 队列是否已满
     */
    private Condition notFull = reentrantLock.newCondition();

    /**
     * 队列是否已空
     */
    private Condition notEmpty = reentrantLock.newCondition();

    /**
     * 队列中的数据存在个数
     */
    private int count;

    /**
     * 队列大小
     */
    private int size;

    private Object[] array;

    /**
     * 队列存在第一个数据的下标
     */
    private int fullIndex;

    private int emptyIndex;

    public MiniBlockingQueue(int size) {
        this.size = size;
        array = new Object[size];
    }

    @Override
    public void put(Object element) {
        reentrantLock.lock();
        try {
            if (this.count == this.size)
                notFull.await();
            // 可以添加成功
            array[fullIndex++] = element;

            if (fullIndex == this.size) {
                fullIndex = 0;
            }

            this.count++;

            // 唤醒
            notEmpty.signal();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override
    public Object take() {
        reentrantLock.lock();
        try {
            if (this.count == 0) {
                notEmpty.await();
            }

            Object element = array[emptyIndex++];

            if (emptyIndex == this.size) {
                emptyIndex = 0;
            }

            this.count--;

            // 唤醒
            notFull.signal();

            return element;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }
        return null;
    }


    public static void main(String[] args) {
        MiniBlockingQueue miniBlockingQueue = new MiniBlockingQueue(10);
        // producer
        new Thread(() -> {
            int i = 0;
            while (true) {
                if (i == 10) {
                    i = 0;
                }
                System.out.println("producer 生产的数字为 "+ i);
                miniBlockingQueue.put(i++);
                try {
                    TimeUnit.MILLISECONDS.sleep(300);
                } catch (InterruptedException e) {
                }
            }
        }).start();

        // consumer
        new Thread(() -> {
            while (true) {
                Object take = miniBlockingQueue.take();
                System.out.println("consumer 生产的数字为 "+ take);
                try {
                    TimeUnit.MILLISECONDS.sleep(300);
                } catch (InterruptedException e) {
                }
            }
        }).start();

    }

}
