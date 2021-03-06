package com.adminsys.leetcode.删除排序数组中的重复项;

/**
 * @Author: qiang
 * @Description:
 * @Create: 2020-02-11 13-19
 **/

public class Main {
    /**
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[j]) {
                nums[++j] = nums[i];
            }
        }
        return ++j;
    }

    public static int removeDuplicate(int[] nums) {
        if (nums.length < 3) {
            return nums.length;
        }
        int index = 2;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[index - 2]) {
                nums[i++] = nums[i];
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2,};
        System.out.println(removeDuplicates(nums));
    }
}
