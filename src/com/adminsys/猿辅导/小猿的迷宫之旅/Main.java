package com.adminsys.猿辅导.小猿的迷宫之旅;

import java.util.*;

public class Main {
    private static int[][] next = {
            {0, 1},
            {1, 0},
            {0, -1},
            {-1, 0}
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();
        sc.nextLine();

        int[][] arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            String[] str = sc.nextLine().split(" ");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.valueOf(str[j]);
            }
        }
        int[][][] dp = new int[N][M][K + 1];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = 0; k <= K; k++)
                    dp[i][j][k] = -1;
            }
        }
        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                dp[i][j][K] = dfs(arr, i, j, K, dp);
                max = Math.max(max, dp[i][j][K]);
            }
        }

        System.out.println(max);
    }

    public static int dfs(int[][] arr, int start, int end, int k, int[][][] dp) {
        if (dp[start][end][k] != -1) return dp[start][end][k];
        dp[start][end][k] = 1;
        for (int i = 0; i < 4; i++) {
            int x = start + next[i][0];
            int y = end + next[i][1];
            if (x < 0 || x >= arr.length || y < 0 || y >= arr[0].length) continue;
            if (arr[x][y] > arr[start][end]) dp[start][end][k] = Math.max(dp[start][end][k], dfs(arr, x, y, k, dp) + 1);
            if (arr[x][y] <= arr[start][end] && k > 0)
                dp[start][end][k] = Math.max(dp[start][end][k], dfs(arr, x, y, k - 1, dp) + 1);
        }
        return dp[start][end][k];
    }

}