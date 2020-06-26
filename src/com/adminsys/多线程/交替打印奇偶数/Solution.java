package com.adminsys.多线程.交替打印奇偶数;

/**
 * @author Qiang
 * @version 1.0
 * @description TODO
 * @date 2020/6/26 下午4:40
 **/
public class Solution {
    private static volatile boolean flag = true;
    private static volatile int count = 0;

    public static void main(String[] args) {

        new Thread(() -> {
            while (true) {
                if (count > 10) return;
                if (flag) {
                    System.out.println("奇数线程:" + count);
                    count++;
                    flag = !flag;
                }
            }
        }, "奇数线程").start();
        new Thread(() -> {
            while (true) {
                if (count > 10) return;
                if (!flag) {
                    System.out.println("偶数线程:" + count);
                    count++;
                    flag = !flag;
                }
            }
        }, "偶数线程").start();
    }
}
