package com.adminsys.猿辅导.删除数组中出现次数超过k的删除;

/**
 * @author Qiang
 * @version 1.0
 * @description TODO
 * @date 2020/7/19 下午6:22
 **/
public class Solution {
    public void deleteK(int[] nums, int k) {
        if (nums == null || nums.length == 0) return;
        int index = 0;
        for (int i = 0; i < nums.length;) {
            int j;
            for (j = i + 1; j < nums.length; j++) {
                if (nums[j] != nums[i]) break;
            }
            int t = i;
            i = j;
            if (j - t > k) continue;
            for (int m = t; m < j; m++) nums[index++] = nums[m];
        }
        for (int l = 0; l < index; l++)
            System.out.print(nums[l]+"->");
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 1, 2, 2, 3, 3, 3, 5, 6, 7, 7};
        new Solution().deleteK(arr, 2);
    }
}
