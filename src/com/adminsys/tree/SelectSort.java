package com.adminsys.tree;

import java.util.Arrays;

/**
 * @Author: qiang
 * @Description:
 * @Create: 2020-03-08 15-14
 **/

public class SelectSort {
    public void selectSort(int[] arr) {
        int temp;
        for (int i = 0; i < arr.length; i++) {
            temp = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if(temp > arr[j]){
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 6, 3, 8};
        new SelectSort().selectSort(arr);
    }
}
