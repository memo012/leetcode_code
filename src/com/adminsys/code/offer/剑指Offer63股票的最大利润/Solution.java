package com.adminsys.code.offer.剑指Offer63股票的最大利润;

class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int min, max, count = 0;
        min = max = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (min > prices[i]) min = max = prices[i];
            if (max < prices[i]) {
                max = prices[i];
                if (count < max - min) count = max - min;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {7, 1, 5, 3, 6, 4};
        new Solution().maxProfit(arr);
    }
}