package com.adminsys.leetcode.数组按重数排序;

import java.util.*;

/**
 * @Author: qiang
 * @Description:
 * @Create: 2020-02-11 13-37
 **/

public class Main {
    public static void sort(int[] data) {
        HashMap<Integer, Integer> h = new HashMap<>();
        for (int i = 0; i < data.length; i++) {
            if (h.get(data[i]) == null) {
                h.put(data[i], 1);
            } else {
                h.put(data[i], h.get(data[i]) + 1);
            }
        }
        Set<Map.Entry<Integer, Integer>> entries = h.entrySet();
        List<Map.Entry<Integer, Integer>> infoIds = new ArrayList<>(entries);
        Collections.sort(infoIds, (o1, o2) -> (o2.getValue() - o1.getValue()));
        int a=0;
        for (int i = 0; i < infoIds.size(); i++) {
            for (int j = 0; j < infoIds.get(i).getValue(); j++) {
                Integer id = infoIds.get(i).getKey();
                System.out.print(id+" ");
            }
        }
    }

    public static void main(String[] args) {
        int[] arrayA = {1, 1, 2, 3, 4, 4, 6, 7, 7, 7};
        sort(arrayA);
        System.out.println(Arrays.toString(arrayA));
    }
}
