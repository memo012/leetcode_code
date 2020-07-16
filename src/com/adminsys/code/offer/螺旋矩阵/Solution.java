package com.adminsys.code.offer.螺旋矩阵;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;
        int count = 0;
        int sum = matrix.length * matrix[0].length;
        while (count < sum) {
            for (int i = left; i <= right; i++) res.add(matrix[top][i]);
            if (++top > bottom) break;
            for (int i = top; i <= bottom; i++) res.add(matrix[i][right]);
            if (--right < left) break;
            for (int i = right; i >= left; i--) res.add(matrix[bottom][i]);
            if (--bottom < top) break;
            for (int i = bottom; i >= top; i--) res.add(matrix[i][left]);
            if (++left > right) break;
        }
        return res;
    }
}