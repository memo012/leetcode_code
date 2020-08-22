package com.adminsys.滴滴.one;

import java.util.Scanner;

/**
 * @author Qiang
 * @version 1.0
 * @description TODO
 * @date 2020/8/21 下午7:48
 **/
import java.util.*;

public class Main {
    static class Node {
        Integer key;
        Integer value;

        public Node(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> use = new ArrayList<>();

        PriorityQueue<Node> queue = new PriorityQueue<Node>(
                (Node n1, Node n2) -> n1.key.compareTo(n2.key)
        );

        for (int i = 100; i <= 999; i++) {
            char[] chars = String.valueOf(i).toCharArray();
            int k = Integer.parseInt(chars[0] + "") * 100 + Integer.parseInt(chars[2] + "") * 10 + Integer.parseInt(chars[2] + "");
            if (use.contains(k)) break;
            if (k + i == n && (chars[0] != chars[1] && chars[0] != chars[2] && chars[1] != chars[2])) {
                use.add(i);
                use.add(k);
                queue.add(new Node(i, k));
            }
        }

        System.out.println(queue.size());

        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            System.out.println(poll.key + " " + poll.value);
        }
    }
}
