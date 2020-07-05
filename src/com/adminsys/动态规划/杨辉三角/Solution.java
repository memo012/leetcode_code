package com.adminsys.动态规划.杨辉三角;

/**
 * @author Qiang
 * @version 1.0
 * @description TODO
 * @date 2020/7/2 下午10:27
 **/
public class Solution {
    void init(int n) {
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j <= i; j++)
                if (j == 0) arr[i][j] = 1;
                else arr[i][j] = arr[i-1][j] + arr[i-1][j-1];

        System.out.println(arr[3][3]);
    }

    public static void main(String[] args) {
        new Solution().init(5);
    }

}
