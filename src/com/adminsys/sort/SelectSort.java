package com.adminsys.sort;

import java.util.Arrays;

/**
 * @Author: qiang
 * @Description:
 * @Create: 2020-06-09 14-47
 **/

public class SelectSort {
    public void selectSort(int[] arr) {
        int length = arr.length;
        int temp;
        for (int i = 0; i < length; i++) {
            temp = arr[i];
            for (int j = i + 1; j < length; j++) {
                if (temp > arr[j]) {
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
