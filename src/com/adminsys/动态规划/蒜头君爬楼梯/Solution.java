package com.adminsys.动态规划.蒜头君爬楼梯;

/**
 * @author Qiang
 * @version 1.0
 * @description 蒜头君爬楼梯 每次可以跳跃任意奇数的楼梯，比如他初始在楼底, 跨越一个阶梯
 * 到达1号楼梯 或者 跨越3个楼梯到达3号阶梯
 * @date 2020/7/4 下午4:34
 **/
public class Solution {
    int mod = 100007;
    public int method(int n) {
        int[] dp = new int[1010];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            dp[i] = 0;
            for (int j = i - 1; j >= 0; j -= 2) {
                dp[i] += dp[j];
                dp[i] %= mod;
            }
        }
        return dp[n];
    }
}
