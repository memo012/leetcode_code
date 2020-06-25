package com.adminsys.code.offer.leetcode215数组中的第K个最大元素;

class Solution {
    private int res;

    public int findKthLargest(int[] nums, int k) {
        findK(nums, 0, nums.length - 1, k);
        return res;
    }

    public void findK(int[] nums, int left, int right, int k) {
        int temp;
        temp = getKTop(nums, left, right);
        if (temp == k - 1) {
            res = nums[temp];
            System.out.println(res);
        } else if (temp > k - 1) {
            findK(nums, left, temp - 1, k);
        } else {
            findK(nums, temp + 1, right, k);
        }
    }

    public int getKTop(int[] arr, int left, int right) {
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

    public static void main(String[] args) {
        int[] a = {3, 2, 1, 5, 6, 4};
        new Solution().findKthLargest(a, 2);
    }
}