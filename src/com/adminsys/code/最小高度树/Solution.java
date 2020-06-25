package com.adminsys.code.最小高度树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        List<Integer> res = new ArrayList<>();
        if (n == 1) {
            res.add(0);
            return res;
        }

        int[] degree = new int[n];
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }

        for (int[] in : edges) {
            degree[in[0]]++;
            degree[in[1]]++;
            list.get(in[0]).add(in[1]);
            list.get(in[1]).add(in[0]);
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) queue.add(i);
        }

        while (!queue.isEmpty()) {
            int width = queue.size();
            res = new ArrayList<>();
            for (int i = 0; i < width; i++) {
                int mid = queue.poll();
                res.add(mid);
                for (Integer in : list.get(mid)) {
                    degree[in]--;
                    if (degree[in] == 1) queue.add(in);
                }
            }
        }

        return res;

    }

}