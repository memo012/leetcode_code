package com.adminsys.code.重新规划路线;

import java.util.*;

class Solution {
    public int minReorder(int n, int[][] connections) {
        Map<Integer, HashSet<Integer>> in = new HashMap<>();
        Map<Integer, HashSet<Integer>> out = new HashMap<>();
        for (int[] i : connections) {
            out.computeIfAbsent(i[0], x -> new HashSet<>()).add(i[1]);
            in.computeIfAbsent(i[1], x -> new HashSet<>()).add(i[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        int res = 0;
        while (!queue.isEmpty()) {
            int mid = queue.poll();
            if (in.get(mid) != null && in.get(mid).size() > 0) {
                for (Integer i : in.get(mid)) {
                    queue.add(i);
                    out.get(i).remove(mid);
                }
                in.remove(mid);
            }
            if (out.get(mid) != null && out.get(mid).size() > 0) {
                for (Integer i : out.get(mid)) {
                    res++;
                    queue.add(i);
                    if (in.get(i) != null)
                        in.get(i).remove(mid);
                }
            }
        }
        return res;
    }
}