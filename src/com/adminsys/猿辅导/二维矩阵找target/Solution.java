package com.adminsys.猿辅导.二维矩阵找target;

/**
 * @author Qiang
 * @version 1.0
 * @description TODO
 * @date 2020/7/17 下午9:38
 **/
public class Solution {
    public static boolean findTarget(int[][] nums, int target) {
        if (nums == null || nums.length < 0) return false;
        int top = 0;
        int bottom = nums.length - 1;
        int left = 0;
        int right = nums[0].length - 1;
        while (top <= bottom && right >= left) {
            if (nums[top][right] == target) return true;
            else if (nums[top][right] > target){
                int mid = (left + right) / 2;
                right = mid;
            }
            else{
                int mid = (top + bottom) / 2;
                top = mid;
            }
        }
        return false;
    }


    public static void main(String args[]) {
        int[][] arr = {
                {1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 15}
        };
        System.out.println(findTarget(arr, 98));
    }

}
