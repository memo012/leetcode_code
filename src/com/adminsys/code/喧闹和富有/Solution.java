package com.adminsys.code.喧闹和富有;

import java.util.*;

class Solution {

    public int[] loudAndRich(int[][] richer, int[] quiet) {
        if (richer == null || richer.length <= 0) return new int[]{};
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        int rl = richer.length;
        int dl = richer[0].length;
        int ql = quiet.length;
        int[] res = new int[ql];
        Arrays.fill(res, -1);
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < ql; i++) {
            list.add(quiet[i]);
        }
        for (int[] in : richer) {
            int nq = list.get(in[0]);
            map.computeIfAbsent(in[1], x -> new ArrayList<Integer>()).add(nq);
        }

        for (Integer m : map.keySet()) {
            Queue<Integer> queue = new LinkedList<>();
            queue.add(m);
            while (!queue.isEmpty()) {
                int mid = queue.poll();
                if (!map.containsKey(mid)) continue;
                for (Integer in : map.get(mid)) {
                    queue.add(in);
                    if (res[mid] != -1 && res[mid] <= in) continue;
                    res[mid] = in;
                }
            }
        }

        for (int i = 0; i < ql; i++)
            if (res[i] == -1) res[i] = quiet[i];

        return res;
    }
}