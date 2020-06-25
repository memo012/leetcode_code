package com.adminsys.code.组合;

import java.util.ArrayList;
import java.util.List;

/**
 *  思路：
 *      深度优先搜索 每层枚举第U个数选哪个，一共枚举K层。
 *      需要记录一个start值 表示当前数需要从几开始，来保证所选的数递增
 */
class Solution {

    List<List<Integer>> lists = new ArrayList<>();
    List<Integer> list = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        dfs(0, 1, n, k);
        return lists;
    }

    public void dfs(int u, int start, int n, int k) {
        if (u == k) {
            lists.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i <= n; i++) {
            list.add(i);
            dfs(u + 1, i + 1, n, k);
            list.remove(list.size() - 1);
        }
    }
}