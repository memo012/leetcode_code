package com.adminsys.leetcode.数组中两个元素得最小距离;

/**
 * @Author: qiang
 * @Description:
 * @Create: 2020-02-19 09-23
 **/

public class Main {
    public static void minDistance(int[] arr, int n1, int n2) {
        int length = arr.length;
        if (length <= 0) {
            return;
        }
        int index_n1 = -1;
        int index_n2 = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < length; i++) {
            if (arr[i] == n1) {
                index_n1 = i;
                if (index_n2 >= 0) {
                    min = Math.min(min, Math.abs(index_n1 - index_n2));
                }
            }
            if (arr[i] == n2) {
                index_n2 = i;
                if (index_n1 >= 0) {
                    min = Math.min(min, Math.abs(index_n1 - index_n2));
                }
            }
        }
        System.out.println("数组中两个元素的最小距离：" + min);
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 4, 7, 4, 6, 4, 7, 8, 5, 6, 4, 3, 10, 8};
        minDistance(arr, 4, 8);
    }
}
