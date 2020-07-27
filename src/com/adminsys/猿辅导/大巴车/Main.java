package com.adminsys.猿辅导.大巴车;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i <= n / m; i++) lists.add(new ArrayList<>());
        int index = 0;
        for (int i = 0; i < n; i++) {
            int k = sc.nextInt();
            if (i != 0 && i % m == 0) index++;
            lists.get(index).add(k);
        }

        for (int i = lists.size() - 1; i >= 0; i--) {
            List<Integer> list = lists.get(i);
            for (int j = 0; j < list.size(); j++)
                System.out.print(list.get(j) + " ");
        }
    }
}