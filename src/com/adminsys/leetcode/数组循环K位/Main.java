package com.adminsys.leetcode.数组循环K位;

import java.util.Arrays;

/**
 * @Author: qiang
 * @Description:
 * @Create: 2020-02-19 08-28
 **/

public class Main {
    // 思路
    // 把前k位进行逆序  把k to  末尾 进行逆序  最后  整个数组逆序
    public static void reverse(int[] arr, int begin, int end) {
        for (; begin < end; begin++, end--) {
            int temp = arr[begin];
            arr[end] = arr[begin];
            arr[begin] = temp;
        }
    }

    public static void reverse(int[] arr, int k) {
        int length = arr.length;
        k = k % length;
        reverse(arr, length - k, length - 1);
        reverse(arr, 0, length - k - 1);
        reverse(arr, 0, length - 1);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7 ,8};
        reverse(arr, 2);
        System.out.println(Arrays.toString(arr));
    }
}
