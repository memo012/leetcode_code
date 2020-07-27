package com.adminsys.猿辅导.和为K的子数组;

/**
 * @author Qiang
 * @version 1.0
 * @description TODO
 * @date 2020/7/25 下午3:23
 **/
public class Solution {

    public int subarraySum(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int end = i; end >= 0; end--) {
                sum += nums[end];
                if (k == sum) {
                    count++;
                }
            }
        }
        return count;
    }

}
