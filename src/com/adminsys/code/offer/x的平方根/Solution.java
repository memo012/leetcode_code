package com.adminsys.code.offer.x的平方根;

class Solution {
    public int mySqrt(int x) {
        int l = 0, r = x, sum = -1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if ((long) mid * mid <= x) {
                sum = mid;
                l = mid + 1;
            } else r = mid - 1;
        }
        return sum;
    }
}