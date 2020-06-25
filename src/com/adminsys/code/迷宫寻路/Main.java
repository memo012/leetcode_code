package com.adminsys.code.迷宫寻路;


import java.util.Scanner;

/**
 * @Author: qiang
 * @Description:
 * @Create: 2020-03-26 03-29
 **/
public class Main {
    static int count = 10000000;
    static int M;
    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();
        int[][] road = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                road[i][j] = sc.nextInt();
            }
        }
        M--;
        N--;
        dfs(road, 0, 0, 0);
        System.out.println(count);
    }

    public static void dfs(int[][] road, int i, int j, int allnum) {
        allnum += road[i][j];
        if (M == i && N == j) {
            if (allnum < count) {
                count = allnum;
            }
        } else if (M == i && j < N) {
            dfs(road, i, j + 1, allnum);
        } else if (N == j && i < M) {
            dfs(road, i + 1, j, allnum);
        } else if (j < N && i < M) {
            dfs(road, i, j + 1, allnum);
            dfs(road, i + 1, j, allnum);
        }
    }
}
