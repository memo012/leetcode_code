package com.adminsys.code.最大子序和;

class Solution {
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        if (len <= 0) {
            return 0;
        }
        int max = nums[0];
        for (int i = 1; i < len; i++) {
            nums[i] = Math.max(nums[i - 1] + nums[i], nums[i]);
            max = Math.max(max, nums[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(new Solution().maxSubArray(arr));
    }
}