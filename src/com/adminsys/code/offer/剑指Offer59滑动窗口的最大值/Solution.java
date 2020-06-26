package com.adminsys.code.offer.剑指Offer59滑动窗口的最大值;

import java.util.LinkedList;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0) return new int[0];
        int index = 0;
        int[] result = new int[nums.length - k + 1];
        LinkedList<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i])
                queue.pollLast();
            queue.addLast(i);
            if (queue.peekFirst() == (i - k)) queue.pollFirst();
            if (i >= (k - 1)) result[index++] = nums[queue.peekFirst()];
        }
        return result;
    }
}