package com.adminsys.sort;

/**
 * @Author: qiang
 * @Description:
 * @Create: 2020-06-09 16-43
 **/

public class MergeSort {

    public void merge(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            merge(arr, left, mid, temp);
            merge(arr, mid + 1, right, temp);
            merge(arr, left, mid, right, temp);
        }
    }

    public void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;
        int t = 0;
        while (i <= mid && j <= right)
            if (arr[j] <= arr[i])
                temp[t++] = arr[j];
            else
                temp[t++] = arr[i];
        while (i <= mid) temp[t++] = arr[i++];
        while (j <= right) temp[t++] = arr[j++];
        int index = 0;
        int newIndex = left;
        while (newIndex <= right) arr[newIndex++] = temp[index++];
    }
}
