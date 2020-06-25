package com.adminsys.code.贪心.跳跃;

/**
 * @Author: qiang
 * @Description:
 * @Create: 2020-03-01 11-37
 **/

public class Main {
    public boolean canJump(int[] nums){
        int[] index = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            index[i] = i + nums[i];
        }
        int jump = 0;
        int max_index = nums[0];
        while (jump < index.length && jump <= max_index){
            if (max_index < index[jump]) {
                max_index = index[jump];
            }
            jump++;
        }
        if (jump == index.length) {
            return true;
        }
        return false;
    }
}