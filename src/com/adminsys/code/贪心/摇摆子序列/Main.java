package com.adminsys.code.贪心.摇摆子序列;

/**
 * @Author: qiang
 * @Description:
 * @Create: 2020-03-01 09-44
 **/

public class Main {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        int BEGIN = 0;
        int up = 1;
        int down = 2;
        int status = BEGIN;
        int max_length = 1;
        for (int i = 1; i < nums.length; i++) {
            switch (status) {
                case 0:
                    if (nums[i - 1] < nums[i]) {
                        status = up;
                        max_length++;
                    } else if (nums[i - 1] > nums[i]) {
                        status = down;
                        max_length++;
                    }
                    break;
                case 1:
                    if (nums[i - 1] > nums[i]) {
                        status = down;
                        max_length++;
                    }
                    break;
                case 2:
                    if (nums[i - 1] < nums[i]) {
                        status = up;
                        max_length++;
                    }
                    break;
            }
        }
        return max_length;
    }
}
