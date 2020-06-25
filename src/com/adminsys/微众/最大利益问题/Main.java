package com.adminsys.微众.最大利益问题;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @Author: qiang
 * @Description:
 * @Create: 2020-04-09 21-22
 **/
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[][] mat = new int[n][2];
        for (int i = 0; i < n; i++) {
            String[] strings = sc.nextLine().split(" ");
            mat[i][0] = Integer.parseInt(strings[0]);
            mat[i][1] = Integer.parseInt(strings[1]);
        }
        sc.close();
        System.out.println(mostMoney(mat));
    }

    private static int mostMoney(int[][] mat) {
        if (mat.length == 0) return 0;
        // 使用一个最大堆，排序规则为：
        //    先比较 卡片的额外抽卡次数， 额外抽卡次数最多的卡片 的优先级较高
        //    当 卡片的额外抽卡次数 相同时，再比较该卡能获得的钱数，能获得的钱数最多的卡片 的优先级较高
        PriorityQueue<Pair> pairs = new PriorityQueue<>(
                (Pair p1, Pair p2) ->
                        p1.num.equals(p2.num) ? p2.money.compareTo(p1.money) : p2.num.compareTo(p1.num)
        );
        for (int[] arr : mat) pairs.add(new Pair(arr[0], arr[1]));
        int res = 0, count = 1;
        while (!pairs.isEmpty() && count > 0) {
            count--;
            Pair poll = pairs.poll();
            res += poll.money;
            count += poll.num;
        }
        return res;
    }

    public static class Pair {
        Integer money;
        Integer num;
        public Pair(Integer money, Integer num) {
            this.money = money;
            this.num = num;
        }
    }
}