package com.adminsys.code.加油站;

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int[] sum = new int[2 * n];
        for (int i = 0; i < sum.length; i++) {
            sum[i] = gas[i % n] - cost[i % n];
        }
        int start = 0, end = 0, top = 0;
        while (start < n && end < 2 * n) {
            top += sum[end];
            while (top < 0) {
                top -= sum[start];
                start++;
            }
            if (end - start + 1 == n) {
                return start;
            }
            end++;
        }
        return -1;
    }
}