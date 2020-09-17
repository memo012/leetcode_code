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
        int ans = 0;
        for (int i = 1; i < arr.length + 1; i++) {
            dp[i] = 1;
            for (int j = 1; j < i; j++)
                if (arr[j] < arr[i])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    public int[] LIS(int[] arr) {
        int length = arr.length;
        // 子序列的值
        int[] end = new int[length + 1];
        // 子序列个数
        int[] dp = new int[length];
        end[1] = arr[0];
        dp[0] = 1;
        int len = 1;
        for (int i = 0; i < length; i++) {
            if (end[len] < arr[i]) {
                end[++len] = arr[i];
                dp[i] = len;
            } else {
                int l = 0;
                int r = len;
                while (l <= r) {
                    int mid = (l + r) >> 1;
                    if (end[mid] >= arr[i]) r = mid - 1;
                    else l = mid + 1;
                }
                end[l] = arr[i];
                dp[i] = l;
            }
        }
        int[] res = new int[len];
        for (int i = length - 1; i >= 0; i--) {
            if (dp[i] == len) res[--len] = arr[i];
        }
        return res;
    }
}
