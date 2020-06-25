package com.adminsys.leetcode.数组中第二个大数字;

/**
 * @Author: qiang
 * @Description:
 * @Create: 2020-02-19 07-53
 **/

public class Main {
    public static void findSecondMax(int[] arr) {
        int max = arr[0];
        int secondMax = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                secondMax = max;
                max = arr[i];
            }
            if (arr[i] < max && arr[i] > secondMax) {
                secondMax = arr[i];
            }
        }
        System.out.println("数组中第二大数字："+secondMax);
    }

    public static void main(String[] args) {
        int[] a = {15, 25, 9, 48, 36, 58, 99, 126, 5};
        findSecondMax(a);
    }
}
