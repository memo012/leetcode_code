package com.adminsys.leetcode.在排序数组中查找数字;

/**
 * @Author: qiang
 * @Description:
 * @Create: 2020-03-04 11-19
 **/

public class Main {

    /**
     *  二分查找
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int m = (i + j) / 2;
            if (nums[m] <= target) i = m + 1;
            else j = m - 1;
        }
        int right = i;
        if (j >= 0 && nums[j] != target) return 0;
        i = 0;
        j = nums.length - 1;
        while (i <= j) {
            int m = (i + j) / 2;
            if (nums[m] < target) i = m + 1;
            else j = m - 1;
        }
        int left = j;
        return right - left - 1;
    }



    public static int getFirstK(int data, int[] arr, int start, int end) {
        if (start > end) {
            return -1;
        }
        int middleIndex = (start + end) / 2;
        int middleNum = arr[middleIndex];
        if (arr[middleIndex] == data) {
            if ((middleIndex > 0 && arr[middleIndex - 1] != data) || middleIndex == 0) {
                return middleIndex;
            } else {
                end = middleIndex - 1;
            }
        } else if (middleNum > data) {
            end = middleIndex - 1;
        } else {
            start = middleIndex + 1;
        }
        return getFirstK(data, arr, start, end);
    }

    public static int getLastK(int data, int[] arr, int start, int end) {
        if (start > end) {
            return -1;
        }
        int middleIndex = (start + end) / 2;
        if (arr[middleIndex] == data) {
            if ((middleIndex < arr.length - 1 && arr[middleIndex + 1] != data) || middleIndex == arr.length - 1) {
                return middleIndex;
            } else {
                start = middleIndex + 1;
            }
        } else if (arr[middleIndex] > data) {
            end = middleIndex - 1;
        } else {
            start = middleIndex + 1;
        }
        return getLastK(data, arr, start, end);
    }

    public static int getNumberOfK(int[] arr, int data){
        int number = 0;
        if(arr.length > 0){
            int first = getFirstK(data, arr, 0, arr.length - 1);
            int last = getLastK(data, arr, 0, arr.length - 1);
            if(first != -1 && last != -1){
                number = last - first + 1;
            }
        }
        return number;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 3, 3, 3, 4, 5};
        System.out.println(getNumberOfK(arr, 3));
    }
}