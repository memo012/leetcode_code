package com.adminsys.code.offer.按摩师;

class Solution {
    public int massage(int[] nums) {
        int length = nums.length;
        if (length == 0) return 0;
        if (length == 1) return nums[0];
        int[][] dp = new int[length][2];
        // 不接受预约
        dp[0][0] = 0;
        // 接受预约
        dp[0][1] = nums[0];
        for (int i = 1; i < length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = dp[i - 1][0] + nums[i];
        }
        return Math.max(dp[length - 1][0], dp[length - 1][1]);
    }

}