package com.adminsys.code.offer.二进制中1的个数;

/**
 * @author Qiang
 * @version 1.0
 * @description TODO
 * @date 2020/8/16 下午3:14
 **/
public class Main {
    public static void getNum1(int num) {
        int count = 0;
        while (num != 0) {
            num = num & (num - 1);
            count++;
        }
        System.out.println(count);
    }

    public static void main(String[] args) {
        getNum1(-1);
        // 负数二进制等于其补码+1
        System.out.println(Integer.toBinaryString(-1));
        System.out.println(Integer.toBinaryString(1));
    }
}
