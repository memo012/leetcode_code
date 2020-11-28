package com;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.RunnableFuture;

/**
 * @author Qiang
 * @version 1.0
 * @description TODO
 * @date 2020/9/22 下午4:03
 **/

class A<T> implements Callable<T> {

    private T value;

    public void set(T value) {
        this.value = value;
    }

    @Override
    public T call() throws Exception {
        System.err.println("线程 " + Thread.currentThread().getName() + " 生产消息" + value);
        return (T) value;
    }
}

class Promise<T> implements Runnable {

    CountDownLatch cdl = new CountDownLatch(1);
    private Callable runnable;
    private static final int NEW = 0;
    private static final int COMPLETING = 1;
    private static final int NORMAL = 2;
    private static int state;
    private Object outcome;

    Promise(Callable runnable) {
        this.runnable = runnable;
        state = NEW;
    }

    public T get() throws Exception {
        int s = state;
        if (s <= COMPLETING)
            s = awaitDone(false, 0L);
        return report(s);
    }

    public void set(T v) {
        outcome = v;
        state = NORMAL;
        cdl.countDown();
    }

    private T report(int s) throws Exception {
        Object x = outcome;
        if (s == NORMAL)
            return (T) x;
        throw new Exception("错误异常");
    }

    private int awaitDone(boolean b, long l) {
        for (; ; ) {
            if (state == COMPLETING) {
                try {
                    cdl.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else if (state == NORMAL) {
                return state;
            }
        }
    }

    @Override
    public void run() {
        if (state == NEW) {
            boolean ran = false;
            T result = null;
            try {
                result = (T) runnable.call();
                ran = true;
            } catch (Exception e) {
                e.printStackTrace();
                ran = false;
            } finally {
                if (ran) setStatus(result);
            }
        }
    }

    protected void setStatus(T v) {
        outcome = v;
        state = NORMAL;
        cdl.countDown();
    }
}

public class Main {

    public static void main(String[] args) throws Exception {
        A<Long> a = new A<>();
        a.set(123L);
        Promise<Long> promise = new Promise<Long>(a);
        Thread td = new Thread(promise);
        td.start();
        System.out.println("消费者消费消息成功:" + promise.get());
    }


}
