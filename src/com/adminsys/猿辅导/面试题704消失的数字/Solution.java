package com.adminsys.猿辅导.面试题704消失的数字;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int missingNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i <= nums.length; i++) set.add(i);
        for (int i = 0; i < nums.length; i++) set.remove(nums[i]);
        int value = 0;
        for (Integer in : set) value = in;
        return value;
    }

    /**
     *  异或
     * @param nums
     * @return
     */
    public int missingNumberTwo(int[] nums) {
        int res = 0;
         for (int i = 0; i < nums.length; i++) {
             res ^= i;
             res ^= nums[i];
         }
         res ^= nums.length;
         return res;
    }
}