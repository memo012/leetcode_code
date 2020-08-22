package com.adminsys.美团.three;


import java.util.*;

/**
 * @Author: qiang
 * @Description:
 * @Create: 2020-04-02 11-28
 **/
public class Main {

    static class Node {
        int key;
        int value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    static int[] father;
    static int[] sz;

    public static void initUF(int n) {
        father = new int[n];
        sz = new int[n];
        for (int i = 0; i < n; i++) {
            father[i] = i;
            sz[i] = 1;
        }
    }

    public static int find(int p) {
        if (p != father[p]) {
            p = find(father[p]);
        }
        return p;
    }

    public static void union(int p, int q) {
        int i = find(p);
        int j = find(q);
        if (i == j) return;
        if (sz[i] < sz[j]) {
            father[i] = j;
            sz[j] += sz[i];
        } else {
            father[j] = i;
            sz[i] += sz[j];
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        initUF(n);
        for (int i = 0; i < m; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            if (find(a - 1) == find(b - 1)) continue;
            union(a - 1, b - 1);
        }
        HashMap<Integer, TreeSet<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) map.put(i, new TreeSet<Integer>());
        for (int i = 0; i < n; i++) map.get(father[i]).add(i + 1);
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.key - o2.key);
        for (int i = 0; i < map.size(); i++) {
            int size = map.get(i).size();
            if (size <= 0) continue;
            SortedSet<Integer> value = map.get(i);
            pq.add(new Node(value.first(), i));
        }
        System.out.println(pq.size());
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            SortedSet<Integer> value = map.get(node.value);
            int len = value.size();
            int ct = 0;
            for (int v : value) {
                ct++;
                if (ct == len) System.out.println(v);
                else System.out.print(v + " ");
            }
        }
    }
}