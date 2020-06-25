package com.adminsys.code.子集;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        if (nums.length <= 0) {
            return lists;
        }
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        dfs(nums, 0, list, lists);
        return lists;
    }

    public void dfs(int[] nums, int step, List<Integer> list, List<List<Integer>> lists) {
        lists.add(new ArrayList<>(list));
        for (int i = step; i < nums.length; i++) {
            if (i > step && nums[i] == nums[i - 1]) {
                continue;
            }
            list.add(nums[i]);
            dfs(nums, i + 1, list, lists);
            list.remove(list.size() - 1);
        }
    }
}