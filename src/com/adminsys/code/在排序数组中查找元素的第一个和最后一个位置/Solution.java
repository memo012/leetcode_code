package com.adminsys.code.在排序数组中查找元素的第一个和最后一个位置;

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = -1, last = -1;
        if (nums.length > 0) {
            first = getFirst(target, nums, 0, nums.length - 1);
            last = getLast(target, nums, 0, nums.length - 1);
        }
        return new int[]{first, last};
    }

    public int getFirst(int data, int[] arr, int start, int end) {
        if (start > end) {
            return -1;
        }
        int middleIndex = (start + end) / 2;
        int middleNum = arr[middleIndex];
        if (middleNum == data) {
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
        return getFirst(data, arr, start, end);
    }


    public static int getLast(int data, int[] arr, int start, int end) {
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
        return getLast(data, arr, start, end);
    }

}