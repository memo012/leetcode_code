package com.adminsys.leetcode.求最大子数组之和;

/**
 * @Author: qiang
 * @Description:
 * @Create: 2020-02-19 08-04
 **/

public class Main {

    public static void maxSubArray(int[] arr) {
        int length = arr.length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < length; i++) {
            int maxValue = 0;
            for (int j = i; j < length; j++) {
                maxValue += arr[j];
                if (maxValue > max) {
                    max = maxValue;
                }
            }
        }
        System.out.println("最大子数组之和:" + max);
    }

    public static void main(String[] args) {
        int[] a = {0, -1, 3, 5};
        maxSubArray(a);
    }
}
