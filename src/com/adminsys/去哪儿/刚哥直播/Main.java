package com.adminsys.去哪儿.刚哥直播;

/**
 * @author Qiang
 * @version 1.0
 * @description TODO
 * @date 2020/9/23 下午7:34
 **/

import java.util.*;

public class Main {
    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();

        int a = 1, b = 1;
        for (int i = 0; i < n; i++) {
            a *= m--;
        }
        System.out.println(a);
        for (int i = n; i >= 1; i--) {
            b *= i;
        }
        System.out.println(b);
        System.out.println(a / b);

//        dfs(1, m, n, new ArrayList<>());
//        System.out.println(count);
    }

    public static void dfs(int start,int m, int n, List<Integer> list) {
        if (list.size() == n) {
            count++;
            return;
        }
        for (int i = start; i <= m; i++) {
            list.add(i);
            dfs(i+1, m, n, list);
            list.remove(list.size()-1);
        }
    }
}
