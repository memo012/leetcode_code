package com.adminsys.sort;

import java.util.Arrays;

/**
 * @Author: qiang
 * @Description:
 * @Create: 2020-06-09 14-51
 **/

public class BubbleSort {
    public void bubbleSort(int[] arr) {
        int length = arr.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
