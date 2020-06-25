package com.adminsys.synchroniz;

import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: qiang
 * @Description:
 * @Create: 2020-03-03 05-26
 **/

public class SynchronizedTest {

    private Lock lock = new ReentrantLock(true);

    public void test1() {
        System.out.println("----------------");
        lock.unlock();
    }

    public void test2() {
        synchronized(this) {

        }
    }

    public static void main(String[] args) {
        new SynchronizedTest().test1();
    }
}
