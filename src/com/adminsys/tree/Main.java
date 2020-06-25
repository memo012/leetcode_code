package com.adminsys.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        permute(sc.nextInt());
    }
    public static List<List<Integer>> permute(int len) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> lists = new ArrayList<>();
        dfs(0, len, list, lists);
        return lists;
    }
    public static void dfs(int step, int len, List<Integer> list, List<List<Integer>> lists) {
        lists.add(new ArrayList<>(list));
        for (int i = step; i < len; i++) {
            list.add(i);
            dfs(i + 1, len, list, lists);
            list.remove(list.size() - 1);
        }
    }
}