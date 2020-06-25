package com.adminsys.code.火柴拼正方形;

import java.util.Arrays;

class Solution {

    public boolean makesquare(int[] nums) {
        int length = nums.length;
        if (length < 4) return false;
        int sums = 0;
        for (Integer i : nums) sums += i;
        if (sums % 4 != 0) return false;
        int t = sums / 4;
        Arrays.sort(nums);
        boolean[] flag = new boolean[nums.length];
        for (int i = 0; i < 3; i++) {
            for (int j = length - 1; j >= 0; j--) {
                if (!flag[j]) {
                    flag[j] = true;
                    boolean b = find(nums, flag, j - 1, t - nums[j]);
                    if (!b) return false;
                }
            }
        }
        return true;
    }
    public boolean find(int[] nums, boolean[] flag, int index, int t) {
        if (t == 0) return true;
        for (int i = index; i >= 0; i--) {
            if (!flag[i] && nums[i] <= t) {
                flag[i] = true;
                boolean b = find(nums, flag, i - 1, t - nums[i]);
                if (b) return true;
                flag[i] = false; 
            }
        }
        return false;
    }
}