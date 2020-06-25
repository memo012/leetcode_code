package com.adminsys.code.全排列;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    public List<List<Integer>> permute(int[] nums) {
        int[] book;
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> lists = new ArrayList<>();
        int len = nums.length;
        book = new int[len];
        dfs(0, len, nums, list, lists, book);
        return lists;
    }

    public void dfs(int step, int len, int[] nums, List<Integer> list, List<List<Integer>> lists, int[] book) {
        if (step == len) {
            if (!lists.contains(list)) {
                lists.add(new ArrayList<>(list));
            }
            return;
        }
        for (int i = 0; i < len; i++) {
            if (book[i] == 0) {
                list.add(nums[i]);
                book[i] = 1;
                dfs(step + 1, len, nums, list, lists, book);
                book[i] = 0;
                list.remove(list.size() - 1);
            }
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        // 排序（升序或者降序都可以），排序是剪枝的前提
        Arrays.sort(nums);

        boolean[] used = new boolean[len];
        List<Integer> list = new ArrayList<>();
        dfsTwo(nums, len, 0, used, list, res);
        return res;
    }

    private void dfsTwo(int[] nums, int len, int step, boolean[] used, List<Integer> list, List<List<Integer>> res) {
        if (step == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < len; i++) {
            if (used[i]) {
                continue;
            }
            // 剪枝条件：i > 0 是为了保证 nums[i - 1] 有意义
            // 写 !used[i - 1] 是因为 nums[i - 1] 在深度优先遍历的过程中刚刚被撤销选择
            if (i > 0 && nums[i] != nums[i - 1] && !used[i - 1]) {
                continue;
            }
            list.add(nums[i]);
            used[i] = true;
            dfsTwo(nums, len, step + 1, used, list, res);
            used[i] = false;
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        new Solution().permute(arr);
    }
}