package com.adminsys.code.offer.面试题0805递归乘法;

class Solution {
    public int multiply(int A, int B) {
        if (A == 0 || B == 0) return 0;
        return plus(A, B, A);
    }

    public int plus(int A, int B, int n) {
        if (B != 1) return plus(A + n, B - 1, n);
        return A;
    }
}