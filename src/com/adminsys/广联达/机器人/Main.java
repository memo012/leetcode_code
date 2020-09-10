package com.adminsys.广联达.机器人;

/**
 * @author Qiang
 * @version 1.0
 * @description TODO
 * @date 2020/9/9 下午8:17
 **/

import java.util.*;

public class Main {
    static class Pair {
        Float x;
        Integer y;

        Pair(float x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = sc.nextInt();
        PriorityQueue<Pair> pairs = new PriorityQueue<>(
                (Pair p1, Pair p2) ->
                        p1.y.equals(p2.y) ? p1.x.compareTo(p2.x) : p2.y.compareTo(p1.y)
        );
        for (int i = 0; i < n; i++) {
            float x = sc.nextFloat();
            int y = sc.nextInt();
            pairs.add(new Pair(x, y));
        }

        int res = 0;
        while (!pairs.isEmpty()) {
            Pair p = pairs.poll();
            if (p.x <= c) {
                res += p.y;
                c -= p.x;
            }
        }
        System.out.println(res);

    }
}
