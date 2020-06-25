package com.adminsys.code.offer.数组中出现次数超过一半的数字;

import java.util.HashMap;

class Solution {
    public int majorityElement(int[] nums) {
        int length = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < length; i++) {
            if (!map.containsKey(nums[i])) map.put(nums[i], 1);
            map.put(nums[i], map.get(nums[i]) + 1);
            int value = map.get(nums[i]);
            if (max == Integer.MIN_VALUE || value > map.get(max)) max = nums[i];
            if (map.get(max) > length / 2) return max;
        }
        return -1;
    }
}