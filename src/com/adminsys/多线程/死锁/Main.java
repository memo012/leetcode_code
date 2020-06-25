package com.adminsys.多线程.死锁;

/**
 * @Author: qiang
 * @Description:
 * @Create: 2020-04-03 04-03
 **/
class DeadLock implements Runnable {

    private int value;
    private static Object o1 = new Object();
    private static Object o2 = new Object();

    public DeadLock(int value) {
        this.value = value;
    }

    @Override
    public void run() {
        if (value == 0) {
            synchronized (o1) {
                try {
                    Thread.sleep(3000);
                    for (int i = 11; i < 20; i++) {
                        System.out.println("o1-" + i);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                synchronized (o2) {
                    System.out.println("o2-" + value);
                }
            }
        }
        if (value == 1) {
            synchronized (o2) {
                try {
                    Thread.sleep(3000);
                    for (int i = 1; i < 10; i++) {
                        System.out.println("o2-" + i);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                synchronized (o1) {
                    System.out.println("o1-" + value);
                }
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        DeadLock d1 = new DeadLock(0);
        DeadLock d2 = new DeadLock(1);
        new Thread(d1).start();
        new Thread(d2).start();
    }
}
