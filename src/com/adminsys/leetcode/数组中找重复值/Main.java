package com.adminsys.leetcode.数组中找重复值;

/**
 * @Author: qiang
 * @Description:
 * @Create: 2020-02-19 09-02
 **/

public class Main {
    public static void findDup(int[] arr) {
        int length = arr.length;
        int j = 0;
        boolean flag = false;
        for (int i = 1; i < length; i++) {
            if (arr[j] != arr[i]) {
                arr[++j] = arr[j];
            } else {
                flag = true;
                break;
            }
        }
        if (flag) {
            System.out.println(arr[j]);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 3, 4};
        findDup(arr);
    }

}
