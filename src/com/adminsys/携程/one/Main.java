package com.adminsys.携程.one;

import java.util.*;

/**
 * @author Qiang
 * @version 1.0
 * @description TODO
 * @date 2020/8/15 下午7:07
 **/
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        TreeSet<Integer> list = new TreeSet<>();
        for (int i = 0; i <= k; i++) {
            int mid = n * i + m * (k - i);
            list.add(mid);
        }
        int[] res = new int[list.size()];
        int i = 0;
        for (int in : list) res[i++] = in;

//       int[] abb = divingBoard(n, m, k);
       for (int ii = 0; ii < res.length; ii++) System.out.println(res[ii]);
    }

    static int[] divingBoard(int a, int b, int k) {
        int[] arr = new int[]{a, b};
        TreeSet<Integer> list = new TreeSet<>();
        dfs(arr, 0, k, list, 0);
        if (k == 0){
            Arrays.sort(arr);
            return arr;
        }
        if (list.isEmpty()) return new int[]{};
        int[] res = new int[list.size()];
        int i = 0;
        for (int in : list) res[i++] = in;
        return res;
    }

    static void dfs(int[] nums, int step, int k, TreeSet<Integer> list, int sum) {
        if (k == 0) {
            list.add(sum);
            return;
        }
        for (int i = step; i < nums.length; i++) {
            sum += nums[i];
            k--;
            dfs(nums, i, k, list, sum);
            k++;
            sum -= nums[i];
        }
    }
}
