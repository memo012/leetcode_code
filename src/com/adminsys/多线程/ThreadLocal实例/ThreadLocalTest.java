package com.adminsys.多线程.ThreadLocal实例;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Qiang
 * @version 1.0
 * @description TODO
 * @date 2020/7/3 下午9:57
 **/
public class ThreadLocalTest {
    private static final AtomicInteger nextId = new AtomicInteger();
    private static ThreadLocal<Integer> threadId = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return nextId.getAndIncrement();
        }
    };

    public static int get() {
        return threadId.get();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> System.out.println(ThreadLocalTest.get())).start();
        }
    }

}
