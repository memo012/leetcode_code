package com.adminsys.leetcode.零到n缺失的数字;

/**
 * @Author: qiang
 * @Description:
 * @Create: 2020-03-04 12-15
 **/

public class Main {
    public static int getMissingNumber(int[] arr) {
        if (arr.length < 0) {
            return -1;
        }
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (mid != arr[mid]) {
                if (mid == 0 || arr[mid - 1] == mid - 1) {
                    return mid;
                } else {
                    right = mid - 1;
                }
            } else {
                left = mid + 1;
            }
        }
        if (left == right) {
            return arr.length - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 4, 4};
        System.out.println(getMissingNumber(arr));
    }
}
