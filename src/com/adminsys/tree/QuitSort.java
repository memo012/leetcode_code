package com.adminsys.tree;

import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: qiang
 * @Description:
 * @Create: 2020-02-09 06-02
 **/

public class QuitSort {

    /**
     * 快拍
     *
     * @param arr
     * @param left
     * @param right
     */
    public static void quit(int[] arr, int left, int right) {
        if (left > right) {
            return;
        }
        int i = left;
        int j = right;
        int temp = arr[left];
        while (i != j) {
            while (i < j && arr[j] >= temp) {
                j--;
            }
            while (i < j && arr[i] <= temp) {
                i++;
            }
            if (i < j) {
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }
        }
        arr[left] = arr[i];
        arr[i] = temp;
        quit(arr, left, i - 1);
        quit(arr, i + 1, right);
    }

    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(1);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(1);
        ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<>();
        map.put(1, 1);
        int[] a = {1, 1, 2, 3, 4, 4, 6, 7, 7, 7};
        int length = a.length - 1;
        quit(a, 0, length);
        System.out.println(Arrays.toString(a));
    }
}