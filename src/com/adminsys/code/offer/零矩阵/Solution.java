package com.adminsys.code.offer.零矩阵;

class Solution {
    public void setZeroes(int[][] matrix) {
        int r = matrix.length;
        int l = matrix[0].length;
        boolean[] user = new boolean[r];
        boolean[] usel = new boolean[l];
        for (int i = 0; i < r; i++)
            for (int j = 0; j < l; j++)
                if (matrix[i][j] == 0) {
                    user[i] = true;
                    usel[j] = true;
                }

        for (int i = 0; i < r; i++)
            for (int j = 0; j < l; j++)
                if (user[i] || usel[j]) matrix[i][j] = 0;
                
    }
}