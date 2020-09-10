package com.adminsys.同城58.输入公共字符串;

/**
 * @author Qiang
 * @version 1.0
 * @description TODO
 * @date 2020/8/31 下午8:41
 **/

import java.util.*;

public class Main {
    public ArrayList<String> findCommonString(ArrayList<ArrayList<String>> values) {
        // write code here
        if (values == null || values.isEmpty()) return new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        int size = values.size();
        for (int i = 0; i < size; i++) {
            ArrayList<String> value = values.get(i);
            Set<String> set = new HashSet<>(value);
            for (int j = 0; j < set.size(); j++) {
                map.put(value.get(j), map.getOrDefault(value.get(j), 0) + 1);
            }
        }
        ArrayList<String> res = new ArrayList<>();
        for (Map.Entry<String, Integer> m : map.entrySet()) {
            if (m.getValue() >= size) res.add(m.getKey());
        }
        return res;
    }
}
