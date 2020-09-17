package com.adminsys.douyu.行走的机器人;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Qiang
 * @version 1.0
 * @description TODO
 * @date 2020/9/17 下午4:07
 **/
public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 移动的次数
     * @param m int整型
     * @param n int整型
     * @param k int整型
     * @return int整型
     */
    public int count = 0;
    private int[][] next = {
            {0, 1},
            {1, 0},
            {0, -1},
            {-1, 0}
    };

    class Node {
        int x;
        int y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    int[][] arr;
    public int movingCount (int m, int n, int k) {
        // write code here
        if (k == 0) return 1;
        arr = new int[m][n];
        arr[0][0] = 1;
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0));
        int count = 1;
        while (!queue.isEmpty()) {
            Node pl = queue.poll();
            for (int i = 0; i < 4; i++) {
                int tx = pl.x + next[i][0];
                int ty = pl.y + next[i][1];
                if (tx < 0 || tx >= m || ty < 0 || ty >= n) continue;
                int sum = 0;
                int x = tx, y = ty;
                while (x != 0) {
                    sum += x % 10;
                    x /= 10;
                }
                while (y != 0) {
                    sum += y % 10;
                    y /= 10;
                }
                if (arr[tx][ty] == 0 && sum <= k) {
                    arr[tx][ty] = 1;
                    queue.add(new Node(tx, ty));
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().movingCount(2, 3, 1));

    }

}
