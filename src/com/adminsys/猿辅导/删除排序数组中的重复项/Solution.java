package com.adminsys.猿辅导.删除排序数组中的重复项;

class Solution {
    public int removeDuplicates(int[] nums) {
       if (nums.length < 2) return nums.length;
       int j = 0;
       for (int i = 1; i  < nums.length; i++) {
           if (nums[i] != nums[j]) nums[++j] = nums[i];
       }
       return ++j;
    }
}