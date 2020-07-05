package com.adminsys.动态规划.最大子序和;

/**
 * @author Qiang
 * @version 1.0
 * @description TODO
 * @date 2020/7/4 下午4:55
 **/
public class Solution {
    public int maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++)
            res = Math.max(res, nums[i]);
        if (res <= 0) return res;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum + nums[i] < 0) sum = 0;
            else sum += nums[i];
            res = Math.max(res, sum);
        }
        return res;
    }
}