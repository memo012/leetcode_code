package com.adminsys.猿辅导.旋转数组serarchTarget;

/**
 * @author Qiang
 * @version 1.0
 * @description TODO
 * @date 2020/7/31 下午8:14
 **/
public class Solution {

    public int searchTarget(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            int mid = (i + j) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] < nums[j]) {
                if (nums[mid] < target && target <= nums[j]) i += 1;
                else j -= 1;
            } else {
                if (target < nums[mid] && target >= nums[i]) j -= 1;
                else i += 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 4, 5, 6, 7, 0, 1, 2};
        Solution solution = new Solution();
        System.out.println(solution.searchTarget(arr, 5));
        System.out.println(solution.searchTarget(arr, 8));
    }

}
