package com.adminsys.tree;

import java.util.Arrays;

/**
 * @Author: qiang
 * @Description:
 * @Create: 2020-02-08 04-45
 **/

public class MergetSort {
    public static void main(String[] args) {
        int[] arr = {5, 3, 6, 8, 15, 0};
        int[] temp = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1, temp);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 把无序地序列变成有序的序列
     *
     * @param arr   待排序的数据序列
     * @param left  起始点
     * @param right 尾点
     */
    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid, temp);
            mergeSort(arr, mid + 1, right, temp);
            merge(arr, left, mid, right, temp);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;
        int t = 0;
        while (i <= mid && j <= right) {
            if (arr[i] >= arr[j]) {
                temp[t++] = arr[j++];
            } else {
                temp[t++] = arr[i++];
            }
        }
        while (i <= mid) {
            temp[t++] = arr[i++];
        }
        while (j <= right) {
            temp[t++] = arr[j++];
        }
        int index = 0;
        int newTemp = left;
        while (newTemp <= right) {
            arr[newTemp++] = temp[index++];
        }
    }
}