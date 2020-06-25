package com.adminsys.code.网络延迟时间;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 迪杰斯特拉最短路径算法（Dijkstra's）[Accepted]
 * 我们使用【Dijkstra】算法找到从源节点到所有节点的最短距离
 * 【Dijkstra】算法每次扩展一个距离最短的点，更新与其相邻的距离
 */
class Solution {
    public int networkDelayTime(int[][] times, int N, int K) {

        Map<Integer, List<int[]>> graph = new HashMap<>();

        // 预处理
        for (int[] t : times) {
            if (!graph.containsKey(t[0])) {
                graph.put(t[0], new ArrayList<>());
            }
            graph.get(t[0]).add(new int[]{t[1], t[2]});
        }

        Map<Integer, Integer> dist = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            dist.put(i, Integer.MAX_VALUE);
        }

        dist.put(K, 0);
        boolean[] flag = new boolean[N + 1];

        while (true) {
            int index = -1;
            int indexDist = Integer.MAX_VALUE;
            // 找到离根节点距离最近的节点
            for (int i = 1; i <= N; i++) {
                if (!flag[i] && dist.get(i) < indexDist) {
                    index = i;
                    indexDist = dist.get(i);
                }
            }

            if (index < 0) {
                break;
            }

            flag[index] = true;

            // 从当前节点更新到相邻节点的距离
            if (graph.containsKey(index)) {
                for (int[] info : graph.get(index)) {
                    dist.put(info[0],
                            Math.min(dist.get(info[0]), dist.get(index) + info[1]));
                }
            }
        }

        int ans = 0;
        for (int i : dist.values()) {
            if (i == Integer.MAX_VALUE) {
                return -1;
            }
            ans = Math.max(ans, i);
        }
        return ans;
    }
}