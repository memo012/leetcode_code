package com.adminsys.code.offer.最小差值ii;

import java.util.Arrays;

class Solution {
    public int smallestRangeII(int[] A, int K) {
        int length = A.length;
        Arrays.sort(A);
        int res = A[length - 1] - A[0];
        for (int i = 0; i < length - 1; i++) {
            int a = A[i], b = A[i + 1];
            int height = Math.max(A[length - 1] - K, a + K);
            int low = Math.min(A[0] + K, b - K);
            res = Math.min(res, height - low);
        }
        return res;
    }
}