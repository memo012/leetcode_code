package com.adminsys.猿辅导.数组中的第K个最大元素;

class Solution {
    int res;
    public int findKthLargest(int[] nums, int k) {
       findK(nums, 0, nums.length-1, k);
       return res;
    }
    public void findK(int[] nums, int left, int right, int k) {
         int slot = quickSort(nums, left, right);
        if (slot == k - 1)  res = nums[slot];
        else if (slot > k - 1) findK(nums, left, slot-1, k);
        else findK(nums, slot + 1, right, k);
    }
    public int quickSort(int[] nums, int left, int right) {
        int i = left;
        int j = right;
        int mid = nums[left];
        while (i != j) {
            while (i < j && nums[j] <= mid) j--;
            while (i < j && nums[i] >= mid) i++;
            if (i < j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        nums[left] = nums[i];
        nums[i] = mid;
        return i;
    }
}