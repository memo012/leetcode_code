package com.adminsys.leetcode.旋转数组查找元素;

/**
 * @Author: qiang
 * @Description:
 * @Create: 2020-02-19 09-46
 **/

public class Main {
    // 思路
    // 先从旋转数组中查询出最小的元素的位置
    // 查询的元素和第一个元素比较  如果 大于 的话 在前序数组中
    // 小于的话 在后序数组中

    /**
     * 找出旋转数组中的最小元素
     *
     * @param arr
     * @return
     */
    public static int getSplitIndex(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start + 1 < end) {
            int mid = (start + end) / 2;
            // 说明左侧有序，则最小元素在右侧
            if (arr[mid] > arr[start]) {
                start = mid;
            }
            // 说明右侧有序，说明最小元素在左侧
            if (arr[mid] < arr[end]) {
                end = mid;
            }
        }
        // 当退出循环时，一定是end位置的元素小与begin位置的元素
        return end;
    }

    public static int FindNum(int arr[], int k) {
        int start = 0;
        int end = arr.length - 1;
        int split = getSplitIndex(arr);
        if (k >= arr[start]) {
            // 表明待查询元素在前半段
            end = split - 1;
            return binarySearch(arr, k, start, end);
        } else {
            start = split;
            return binarySearch(arr, k, start, end);
        }
    }

    /**
     * 二分查找
     *
     * @param arr
     * @param target
     * @param start
     * @param end
     * @return
     */
    public static int binarySearch(int[] arr, int target, int start, int end) {
        int left = start;
        int right = end;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {6, 1, 2, 3, 4};
        System.out.println(FindNum(arr, 3));
    }

}
