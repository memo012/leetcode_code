package com.adminsys.tree;

import java.util.Arrays;

/**
 * @Author: qiang
 * @Description:
 * @Create: 2020-03-08 15-19
 **/

public class BubbleSort {
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 3, 1, 7, 9};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
