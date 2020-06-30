package com.adminsys.code.offer.剑指Offer66构建乘积数组;

class Solution {
    public int[] constructArr(int[] a) {
        if (a == null || a.length == 0) return new int[]{};
        int length = a.length;
        int[] b = new int[length];
        b[0] = 1;
        int temp = 1;
        // 左下角乘积值
        for (int i = 1; i < length; i++) b[i] = b[i - 1] * a[i - 1];
        // 右上角乘积值
        for (int i = length - 2; i >= 0; i--) {
            temp *= a[i + 1];
            b[i] *= temp;
        }
        return b;
    }
}