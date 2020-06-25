package com.adminsys.leetcode.数组中只出现一次数组;

/**
 * @Author: qiang
 * @Description:
 * @Create: 2020-02-19 08-50
 **/

public class Main {
    public static void findNotDouble(int[] arr) {
        int n = arr.length;
        int result = arr[0];
        for (int i = 1; i < n; i++) {
            result ^= arr[i];
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 2, 4, 3, 5, 4, 1};
        findNotDouble(arr);
    }
}
