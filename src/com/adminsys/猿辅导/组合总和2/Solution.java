package com.adminsys.猿辅导.组合总和2;

import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        if (candidates.length <= 0 || target <= 0) {
            return lists;
        }
        Arrays.sort(candidates);
        List<Integer> list = new ArrayList<>();
        dfs(candidates, 0, target, list, lists);
        return lists;
    }

    public void dfs(int[] nums, int step, int target, List<Integer> list, List<List<Integer>> lists) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            if (!lists.contains(list))
                lists.add(new ArrayList<>(list));
            return;
        }
        for (int i = step; i < nums.length; i++) {
            // 这就是排序的好处，可以直接这样剪枝，否则还得遍历
            if (target < nums[i]) break;
            list.add(nums[i]);
            dfs(nums, i + 1, target - nums[i], list, lists);
            list.remove(list.size() - 1);
        }
    }
}