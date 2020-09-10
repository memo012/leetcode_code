package com.adminsys.广联达.种草;

/**
 * @author Qiang
 * @version 1.0
 * @description TODO
 * @date 2020/9/9 下午7:20
 **/

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long m = sc.nextLong();
        long x = sc.nextLong();
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            long temp = sc.nextLong();
            pq.add(temp);
        }
        for (int i = 0; i < m; i++) {
            long tx = pq.peek();
            pq.remove(tx);
            pq.add(tx + x);
        }
        System.out.println(pq.peek());
    }
}
