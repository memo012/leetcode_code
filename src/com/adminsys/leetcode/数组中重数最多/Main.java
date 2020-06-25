package com.adminsys.leetcode.数组中重数最多;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @Author: qiang
 * @Description:
 * @Create: 2020-02-19 08-13
 **/

public class Main {
    public static void findMostFrequentInArray(int[] arr) {
        int length = arr.length;
        if (length <= 0) {
            return;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }
        int max = 0;
        int most = 0;
        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> next = iterator.next();
            Integer key = next.getKey();
            Integer value = next.getValue();
            if (value > most) {
                max = key;
                most = value;
            }
        }
        System.out.println("数组中重数为:" + max);
    }

    public static void main(String[] args) {
        int[] a = {0, -1, 3, 5, 5, 5};
        findMostFrequentInArray(a);
    }
}
