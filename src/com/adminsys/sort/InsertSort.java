package com.adminsys.sort;

import java.util.Arrays;

/**
 * @Author: qiang
 * @Description:
 * @Create: 2020-06-09 14-54
 **/

public class InsertSort {
    public void insertSort(int[] arr) {
        int length = arr.length;
        for (int i = 1; i < length; i++) {
            int insertValue = arr[i];
            int insertIndex = i - 1;
            while (insertIndex >= 0 && insertValue < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            arr[insertIndex + 1] = insertValue;
        }
        System.out.println(Arrays.toString(arr));
    }
}
