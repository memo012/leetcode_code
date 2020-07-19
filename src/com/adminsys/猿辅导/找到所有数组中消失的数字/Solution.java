package com.adminsys.猿辅导.找到所有数组中消失的数字;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        Map<Integer, Boolean> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) map.put(nums[i], true);
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= nums.length;i ++) {
            if (!map.containsKey(i)) list.add(i);
        }
        return list;
    }
}