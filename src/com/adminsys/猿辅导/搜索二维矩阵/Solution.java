package com.adminsys.猿辅导.搜索二维矩阵;

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;
        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;
        while (right >= left && top <= bottom) {
            if (matrix[top][right] == target) return true;
            else if (matrix[top][right] > target) right--;
            else top++;
        }
        return false;
    }

    /**
     * 二分查找思想
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrixTwo(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;
        int row = getRow(matrix, target);
        return find(matrix[row], target);
    }

    public int getRow(int[][] matrix, int target) {
        int top = 0;
        int bottom = matrix.length - 1;
        int col = matrix[0].length - 1;
        while (top < bottom) {
            int mid = (top + bottom) / 2;
            if (matrix[mid][col] < target) top = mid + 1;
            else bottom = mid;
        }
        return top;
    }

    public boolean find(int[] data, int target) {
        int left = 0;
        int right = data.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (data[mid] == target) return true;
            else if (data[mid] > target) right = mid - 1;
            else left = mid + 1;
        }
        return false;
    }
}