package com.adminsys.顺丰.服务器管理;

/**
 * @author Qiang
 * @version 1.0
 * @description TODO
 * @date 2020/8/20 下午8:41
 **/

import java.util.*;

public class Main {
    public static class Node {
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
        int m = sc.nextInt();
        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            int t = sc.nextInt();
            data[i] = t;
        }
        Arrays.sort(data);

        PriorityQueue<Node> queue = new PriorityQueue<Node>(
                (Node n1, Node n2) -> n1.value.equals(n2.value) ? n2.key.compareTo(n1.key) : n2.value.compareTo(n1.value)
        );

        for (int i = 0; i < m; i++) {
            int t1 = sc.nextInt();
            int t2 = sc.nextInt();
            queue.offer(new Node(t1, t2));
        }

        int sum = 0;
        int i = data.length - 1;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int key = node.key;
            int value = node.value;
            while (i >= 0) {
                if (key <= data[i]) {
                    sum += value;
                    i--;
                }
                break;
            }
        }

        System.out.println(sum);

    }
}
