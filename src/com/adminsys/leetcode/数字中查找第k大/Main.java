package com.adminsys.leetcode.数字中查找第k大;

/**
 * @Author: qiang
 * @Description: 寻找第K个大元素
 * @Create: 2020-02-09 07-59
 **/

public class Main {

    /**
     *
     * @param arr
     * @param left
     * @param right
     * @return
     */
    public static int quit(int[] arr, int left, int right) {
        int i = left;
        int j = right;
        int temp = arr[left];
        while (i != j) {
            while (i < j && arr[j] <= temp ) {
                j--;
            }
            while (i < j && arr[i] >= temp ) {
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
        return i;
    }

    static void findK(int[] arr, int left, int right, int k) {
        int temp;
        temp = quit(arr, left, right);
        if (temp == k - 1) {
            System.out.println("该数组中第" + k + "个大得数字为" + arr[temp]);
        } else if (temp > k - 1) {
            findK(arr, left, temp - 1, k);
        } else {
            findK(arr, temp + 1, right, k);
        }
    }

    public static void main(String[] args) {
        int[] a = {3, 2, 1, 5, 6, 4};
        int length = a.length - 1;
        findK(a, 0, length, 2);

    }

}
