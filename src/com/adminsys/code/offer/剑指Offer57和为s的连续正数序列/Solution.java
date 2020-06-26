package com.adminsys.code.offer.剑指Offer57和为s的连续正数序列;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[][] findContinuousSequence(int target) {
        List<int[]> lists = new ArrayList<>();
        int i = 1, j = 2;
        int sum = i + j;
        while (i <= target / 2) {
            if (sum == target) {
                 int[] res = new int[j -i + 1];
                for (int k = 0; k < res.length; k++) res[k] = i + k;
                lists.add(res);
                sum -= i++;
            }else if (sum > target)  sum -= i++;
            else sum += ++j;
        }
        return lists.toArray(new int[lists.size()][]);
    }
}