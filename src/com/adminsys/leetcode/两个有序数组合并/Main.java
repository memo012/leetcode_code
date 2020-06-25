package com.adminsys.leetcode.两个有序数组合并;

import java.util.Arrays;

/**
 * @Author: qiang
 * @Description:
 * @Create: 2020-02-14 10-20
 **/

public class Main {

    /**
     * 合并两个有序数组
     *
     * @param arrA 数组A
     * @param m    数组A长度
     * @param arrB 数组B
     * @param n    数组B长度
     */
    public static void merge(int[] arrA, int m, int[] arrB, int n) {
        int indexA = m - 1;
        int indexB = n - 1;
        int index = m + n - 1;
        while (index >= 0) {
            if (indexA < 0) {
                arrA[index--] = arrB[indexB--];
            } else if (indexB < 0) {
                arrA[index--] = arrA[indexA--];
            } else if (arrA[indexA] >= arrB[indexB]) {
                arrA[index--] = arrA[indexA--];
            } else if (arrA[indexA] <= arrB[indexB]) {
                arrA[index--] = arrB[indexB--];
            }
        }
    }

    public static void main(String[] args) {
        int[] arrA = {4, 6, 7, 67, 0, 0, 0, 0};
        int[] arrB = {2, 56, 89, 100};
        merge(arrA, 4, arrB, arrB.length);
        System.out.println(Arrays.toString(arrA));
    }

}
