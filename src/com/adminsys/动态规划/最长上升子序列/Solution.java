package com.adminsys.动态规划.最长上升子序列;

/**
 * @author Qiang
 * @version 1.0
 * @description TODO
 * @date 2020/7/5 下午5:45
 **/
public class Solution {
    public int go(int[] arr) {
        int[] dp = new int[arr.length + 1];
        int ans  = 0;
        for (int i = 1; i < arr.length + 1; i++) {
            dp[i] = 1;
            for (int j = 1; j < i; j++)
                if (arr[j] < arr[i])
                    dp[j] = Math.max(dp[i], dp[j] + 1);
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
