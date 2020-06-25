package com.adminsys.code.机制;

import java.util.concurrent.*;

/**
 * @Author: qiang
 * @Description: 十进制 --> 二进制
 * @Create: 2020-05-09 22-11
 **/

public class TenToTwo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        int num = 189;
//        // 十进制 --> 二进制
//        tenToTwo(num);
//        // 二进制 --> 十进制
////        twoToTen(num);
//        // 十进制 --> 八进制
//        tenToEight(num);
//        // 八进制 --> 十进制
//        eightToTen(num);
//        // 十进制 --> 十六进制
//        tenToSixteen(num);
//        // 十六进制 --> 十进制
//        sixteenToTen(num);
        test();
    }

    private static void sixteenToTen(int num) {
    }

    private static void eightToTen(int num) {
    }

    private static void twoToTen(String num) {

    }

    private static void tenToSixteen(int num) {
        String s = "";
        while (num != 0) {
            int t = num % 16;
            char c;
            if (t >= 0 && t < 10) {
                c = (char) (t + '0');
                s = c + s;
            } else {
                c = (char) (t + 'A' - 10);
                s = c + s;
            }
            num /= 16;
        }
        System.out.println(s);
        twoToTen(s);
    }

    private static void tenToEight(int num) {
        String s = "";
        while (num != 0) {
            s = num % 8 + s;
            num /= 8;
        }
        System.out.println(s);
    }

    public static void tenToTwo(int num) {
        String a = "";
        while (num != 0) {
            a = num % 2 + a;
            num = num / 2;
        }
        System.out.println(a);
    }

    public static void test() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Future f1 = executorService.submit(new RunnableTask());
        Future f2 = executorService.submit(new CallableTask<Object>());
        System.out.println(f2.get());
    }

    private static class RunnableTask implements Runnable{
        @Override
        public void run() {
        }
    }

    public static class CallableTask<T> implements Callable {
        @Override
        public Object call() throws Exception {
            return 45;
        }
    }

}