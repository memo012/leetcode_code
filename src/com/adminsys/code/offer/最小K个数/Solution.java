package com.adminsys.code.offer.最小K个数;

import java.util.PriorityQueue;

class Solution {
    public int[] smallestK(int[] arr, int k) {
        if (arr == null || arr.length == 0) return new int[]{};

        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);

        for (int i = 0; i < arr.length; i++) {
            if (queue.size() >= k) {
                if (!queue.isEmpty() && queue.peek() > arr[i]) queue.poll();
                else continue;
            }
            queue.add(arr[i]);
        }
        int[] aa = new int[k];
        int index = 0;
        for (Integer i : queue) aa[index++] = i;
        return aa;
    }
}