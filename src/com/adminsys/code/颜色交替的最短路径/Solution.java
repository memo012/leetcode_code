package com.adminsys.code.颜色交替的最短路径;

import javafx.util.Pair;

import java.util.*;

/**
 * @Author: qiang
 * @Description:
 * @Create: 2020-06-05 18-22
 **/

public class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {

        Map<Integer, List<Integer>> redMap = new HashMap<>();
        Map<Integer, List<Integer>> blueMap = new HashMap<>();
        for (int[] in : red_edges) {
            if (!redMap.containsKey(in[0]))
                redMap.put(in[0], new ArrayList<>());
            redMap.get(in[0]).add(in[1]);
        }
        for (int[] in : blue_edges) {
            if (!blueMap.containsKey(in[0]))
                blueMap.put(in[0], new ArrayList<>());
            blueMap.get(in[0]).add(in[1]);
        }

        int[] redDis = new int[n];
        int[] blueDis = new int[n];

        Arrays.fill(redDis, -1);
        Arrays.fill(blueDis, -1);


        Queue<Integer> redQueue = new LinkedList<>();
        Queue<Integer> blueQueue = new LinkedList<>();
        redQueue.add(0);
        blueQueue.add(0);
        redDis[0] = 0;
        blueDis[0] = 0;

        int row = 0;

        while (!redQueue.isEmpty() || !blueQueue.isEmpty()) {
            Queue<Integer> newRed = new LinkedList<>();
            Queue<Integer> newBlue = new LinkedList<>();

            int size = redQueue.size();
            for (int i = 0; i < size; i++) {
                int v = redQueue.poll();
                for (Integer in : blueMap.getOrDefault(v, new ArrayList<>())) {
                    if (blueDis[in] == -1) {
                        blueDis[in] = row + 1;
                        newBlue.add(in);
                    }
                }
            }

            size = blueQueue.size();
            for (int i = 0; i < size; i++) {
                int v = blueQueue.poll();
                for (Integer in : redMap.getOrDefault(v, new ArrayList<>())) {
                    if (redDis[in] == -1) {
                        redDis[in] = row + 1;
                        newRed.add(in);
                    }
                }
            }

            redQueue = newRed;
            blueQueue = newBlue;
            row++;
        }

        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        for (int i = 0; i < n; i++) {
            if (redDis[i] >= 0 && blueDis[i] >= 0) {
                ans[i] = Math.min(redDis[i], blueDis[i]);
            } else if (redDis[i] >= 0) {
                ans[i] = redDis[i];
            }else {
                ans[i] = blueDis[i];
            }
        }

        return ans;
    }
}
