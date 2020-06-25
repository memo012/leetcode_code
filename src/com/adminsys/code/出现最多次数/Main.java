package com.adminsys.code.出现最多次数;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: qiang
 * @Description:
 * @Create: 2020-03-30 06-39
 **/

public class Main {
    public static void main(String[] args) {
        int[] arr = {2, 1, 2, 3, 4, 5, 2, 6, 6, 6};
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }
        Collection<Integer> values = map.values();
        Integer max = Collections.max(values);
        int key = 0;
        for (Map.Entry<Integer, Integer> mp : map.entrySet()) {
            if (max == mp.getValue()) {
                key = mp.getKey();
                break;
            }
        }
        System.out.println(key);
    }
}
