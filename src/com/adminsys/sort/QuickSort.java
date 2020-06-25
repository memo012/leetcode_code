package com.adminsys.sort;

/**
 * @Author: qiang
 * @Description:
 * @Create: 2020-06-09 14-58
 **/

public class QuickSort {
    public void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort(int[] arr, int start, int end) {
        if (start > end) return;
        int i = start;
        int j = end;
        int temp = arr[start];
        while (i != j) {
            while (i < j && arr[j] >= temp) j--;
            while (i < j && arr[i] <= temp) i++;
            if (i < j) {
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }
        }
        arr[start] = arr[i];
        arr[i] = temp;
        quickSort(arr, start, i - 1);
        quickSort(arr, i + 1, end);
    }
}
