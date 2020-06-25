package com.adminsys.code.offer.面试题29顺时针打印矩阵;


class Solution {
    public int[] spiralOrder(int[][] matrix) {
        if(matrix.length == 0) {
            return new int[0];
        }
        int left, top, right, bottom, count = 0, sum = matrix.length * matrix[0].length, index = 0;
        int[] res = new int[sum];
        left = 0;
        top = 0;
        right = matrix[0].length - 1;
        bottom = matrix.length - 1;
        while (index < sum) {
            for (int i = left; i <= right; i++) {
                res[index++] = matrix[top][i];
            }
            if(++top > bottom){
                break;
            }
            for (int i = top; i <= bottom; i++) {
                res[index++] = matrix[i][right];
            }
            if(--right < left){
                break;
            }
            for (int i = right; i >= left; i--) {
                res[index++] = matrix[bottom][i];
            }
            if(--bottom < top){
                break;
            }
            for (int i = bottom; i >= top; i--) {
                res[index++] = matrix[i][left];
            }
            if(++left > right){
                break;
            }
        }
        return res;
    }
}