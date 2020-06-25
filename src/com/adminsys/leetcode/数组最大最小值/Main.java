package com.adminsys.leetcode.数组最大最小值;

/**
 * @Author: qiang
 * @Description:
 * @Create: 2020-02-19 07-40
 **/

public class Main {

    public static void getMaxAndMin(int[] arr) {
        int max = arr[0];
        int min = arr[0];
        int length = arr.length;
        for (int i = 1; i < length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        System.out.println("数组最小值:" + min);
        System.out.println("数组最大值:" + max);
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 1, 0, 67};
        getMaxAndMin(arr);
    }
}
