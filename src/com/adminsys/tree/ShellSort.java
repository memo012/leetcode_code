package com.adminsys.tree;

import java.util.Arrays;

/**
 * @Author: qiang
 * @Description:
 * @Create: 2020-03-10 13-47
 **/
public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {4, 6, 1, 8, 9};
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void shellSort(int[] arr) {
        int temp = 0;
        for (int i = arr.length / 2; i > 0; i /= 2) {
            for (int j = i; j < arr.length; j++) {
                // 遍历各组中的元素
                for (int k = j - i; k >= 0; k -= i) {
                    if (arr[k] > arr[k + i]) {
                        temp = arr[k];
                        arr[k] = arr[k + i];
                        arr[k + i] = temp;
                    }
                }
            }
        }
    }
}
