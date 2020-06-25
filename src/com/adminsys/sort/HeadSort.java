package com.adminsys.sort;

/**
 * @Author: qiang
 * @Description:
 * @Create: 2020-06-09 16-51
 **/

public class HeadSort {

    public void heapSort(int[] arr) {
        int temp;
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            int tmp = arr[0];
            arr[0] = arr[i];
            arr[i] = tmp;
            adjustHeap(arr, 0, i);
        }
    }

    // 将一个数组调整成一个大顶推
    public void adjustHeap(int[] arr, int i, int length) {
        int temp = arr[i];
        for (int j = 2 * i + 1; j < length; j = 2 * i + 1) {
            if (j + 1 < length && arr[j] < arr[j + 1])
                j++;
            if (arr[j] > temp) {
                arr[i] = arr[j];
                i = j;
            } else break;
        }
        arr[i] = temp;
    }
}