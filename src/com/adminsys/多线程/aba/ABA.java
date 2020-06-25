package com.adminsys.多线程.aba;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @Author: qiang
 * @Description:
 * @Create: 2020-04-13 01-05
 **/
public class ABA {
    private static AtomicInteger atomicInteger = new AtomicInteger(100);
    private static AtomicStampedReference atomicStampedReference = new AtomicStampedReference(100, 0);
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()-> {
                atomicInteger.compareAndSet(100, 101);
                atomicInteger.compareAndSet(101, 100);
        });
        Thread t2 = new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            boolean c3 = atomicInteger.compareAndSet(100, 101);
            System.out.println(c3);
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        Thread t3 = new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            atomicStampedReference.compareAndSet(100, 101, atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1);
            atomicStampedReference.compareAndSet(101, 100, atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1);
        });
        Thread t4 = new Thread(()->{
            int stamp = atomicStampedReference.getStamp();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            boolean b2 = atomicStampedReference.compareAndSet(100, 101, stamp, stamp + 1);
            System.out.println(b2);
        });
        t3.start();
        t4.start();
    }
}