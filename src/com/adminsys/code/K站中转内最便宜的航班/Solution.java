package com.adminsys.code.K站中转内最便宜的航班;

import java.util.PriorityQueue;
/**
 * 从起始地到目的地最少花费金额
 * 使用算法【Dijkstra】
 */

class Solution {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {

        int[][] g = new int[n][n];

        for (int[] f : flights) {
            g[f[0]][f[1]] = f[2];
        }

        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        // 参数一：花费金额  参数二：起始地点  参数三：中转站剩余次数
        heap.offer(new int[]{0, src, K});

        while (!heap.isEmpty()) {

            int[] cur = heap.poll();
            int price = cur[0], place = cur[1], remain = cur[2];

            if (place == dst) {
                return price;
            }

            if (remain >= 0) {
                for (int i = 0; i < n; i++) {
                    if (g[place][i] > 0) {
                        heap.offer(new int[]{price + g[place][i], i, remain - 1});
                    }
                }
            }

        }

        return -1;
    }

}