package com.adminsys.美团.two;


/**
 * @Author: qiang
 * @Description:
 * @Create: 2020-04-02 11-28
 **/

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int count = 0;
        Map<String, String> map = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            String start = in.next();
            String end = in.next();
            map.put(start, end);
            queue.add(start);
        }

        while (!queue.isEmpty()) {
            String std = queue.poll();
            String start = std;
            while (true) {
                String s = map.get(std);
                queue.remove(s);
                if (map.get(s).equals(start)) {
                    count++;
                    break;
                }
                std = s;
            }
        }

        System.out.println(count);

    }
}
