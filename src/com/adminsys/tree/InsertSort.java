package com.adminsys.tree;

import java.util.Arrays;

/**
 * @Author: qiang
 * @Description:
 * @Create: 2020-03-10 13-09
 **/

public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {4, 1, 6, 5, 9};
        insertSort(arr);
    }
    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int insertVal = arr[i];
            int insertIndex = i - 1;
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            arr[insertIndex + 1] = insertVal;
            System.out.println("第" + i + "轮插入");
            System.out.println(Arrays.toString(arr));
        }
    }
}
