package com.adminsys.网易.two;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: qiang
 * @Description:
 * @Create: 2020-04-11 19-21
 **/

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            List<List<Integer>> lists = new ArrayList<>();
            initList(N, lists);
            while (M-- > 0) {
                int op = sc.nextInt();
                if (op == 1) {
                    int x = sc.nextInt();
                    int y = sc.nextInt();
                    List<Integer> lsX = null;
                    List<Integer> lsY = null;
                    List<Integer> kx = new ArrayList<>();
                    List<Integer> ky = new ArrayList<>();
                    int k = 0;
                    boolean flag = false;
                    for (int ls = 0; ls < lists.size(); ls++) {
                        if (lists.get(ls).contains(x) && lists.get(ls).contains(y)) {
                            flag = true;
                            break;
                        }
                        if (lists.get(ls).contains(x)) {
                            lsX = new ArrayList<>(lists.get(ls));
                            k++;
                            kx = lists.get(ls);
                        }else if (lists.get(ls).contains(y)) {
                            lsY = new ArrayList<>(lists.get(ls));
                            k++;
                            ky = lists.get(ls);
                        }
                        if (k == 2) {
                            break;
                        }
                    }
                    if (!flag && lsX != null && lsY != null) {
                        lsX.addAll(lsY);
                        lists.remove(kx);
                        lists.remove(ky);
                        lists.add(lsX);
                    }
                }
                if (op == 2) {
                    int x = sc.nextInt();
                    int k = 0;
                    List<Integer> lsX = new ArrayList<>();
                    boolean flag = false;
                    for (int ls = 0; ls < lists.size(); ls++) {
                        List<Integer> mid = lists.get(ls);
                        if (mid.size() == 1 && mid.contains(x)) {
                            break;
                        }
                        if (mid.size() > 1 && mid.contains(x)) {
                            k = ls;
                            lsX.add(x);
                            flag = true;
                        }
                        if (flag) {
                            break;
                        }
                    }
                    if (!flag) {
                        continue;
                    }
                    List<Integer> list = lists.get(k);
                    int index = 0;
                    flag = false;
                    for (int i = 0; i < list.size(); i++) {
                        if (list.get(i) == x) {
                            index = i;
                            flag = true;
                        }
                        if (flag) {
                            break;
                        }
                    }
                    list.remove(index);
                    lists.add(lsX);
                }
                if (op == 3) {
                    int x = sc.nextInt();
                    boolean flag = false;
                    for (List<Integer> ls :
                            lists) {
                        if (ls.contains(x)) {
                            System.out.println(ls.size());
                            flag = true;
                        }
                        if (flag) {
                            break;
                        }
                    }
                }
            }
        }
    }

    public static void initList(int N, List<List<Integer>> lists) {
        for (int i = 0; i < N; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(i + 1);
            lists.add(list);
        }
    }
}