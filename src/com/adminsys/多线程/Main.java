package com.adminsys.多线程;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: qiang
 * @Description:
 * @Create: 2020-03-11 01-41
 **/

public class Main {

    ReentrantLock reentrantLock = new ReentrantLock();
    Condition aCondition = reentrantLock.newCondition();
    Condition bCondition = reentrantLock.newCondition();

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        orderExecutor();
//        cyclicPrint();
        Main main = new Main();
        System.out.println("main start");
        ExecutorService threadPool = Executors.newSingleThreadExecutor();
        Future<String> future = threadPool.submit(main.new A());
        threadPool.execute(main.new B());
        System.out.println(future.get());
        System.out.println("end");
    }

    private static AtomicInteger numA = new AtomicInteger();
    private static volatile boolean flag;

    /**
     * 线程交替打印
     */
    public static void cyclicPrint() {
        new Thread(() -> {
            while (numA.get() < 10) {
                if (!flag) {
                    System.out.println(Thread.currentThread().getName() + "---" + numA.incrementAndGet());
                    flag = true;
                }
            }
        }).start();
        new Thread(() -> {
            while (numA.get() < 10) {
                if (flag) {
                    System.out.println(Thread.currentThread().getName() + "---" + numA.incrementAndGet());
                    flag = false;
                }
            }
        }).start();
    }

    /**
     * 顺序打印线程ABC
     */
    private static void orderExecutor() {
        Thread threadA = new Thread(() -> {
            System.out.println("执行A");
        });
        Thread threadB = new Thread(() -> {
            System.out.println("执行B");
        });
        Thread threadC = new Thread(() -> {
            System.out.println("执行C");
        });
        try {
            threadC.start();
            threadC.join();
            threadB.start();
            threadB.join();
            threadA.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    class A implements Callable<String> {
        @Override
        public String call() throws Exception {
            return "myCallable";
        }
    }

    class B implements Runnable {
        @Override
        public void run() {
            System.out.println("Runnable");
        }
    }

}
