package com.adminsys.code.offer.leetcode347前K个高频元素;

import java.util.*;

class Solution {

    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums) map.put(i, map.getOrDefault(i, 0) + 1);
        PriorityQueue<Integer> queue =
                new PriorityQueue<>((o1, o2) -> map.get(o1) - map.get(o2));
        for (int i : map.keySet()) {
            queue.add(i);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        List<Integer> list = new ArrayList<>();
        for (Integer i : queue) {
            list.add(i);
        }
        Collections.reverse(list);
        return list;
    }
}