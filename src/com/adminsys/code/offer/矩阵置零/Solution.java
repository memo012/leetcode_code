package com.adminsys.code.offer.矩阵置零;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return;
        int row = matrix.length;
        int low = matrix[0].length;
        Set<Integer> r = new HashSet<>();
        Set<Integer> l = new HashSet<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < low; j++) {
                if (matrix[i][j] == 0) {
                    r.add(i);
                    l.add(j);
                }
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < low; j++) {
                if (r.contains(i) || l.contains(j))
                    matrix[i][j] = 0;
            }
        }
    }
}