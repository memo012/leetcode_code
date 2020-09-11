package com.adminsys.code.offer.map集合删除指定元素;

import java.util.HashMap;

/**
 * @author Qiang
 * @version 1.0
 * @description TODO
 * @date 2020/9/11 上午7:53
 **/
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 2);
        map.put(3, 4);
        map.put(5, 6);
        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> next = iterator.next();
            int value = next.getValue();
            if (value == 4) iterator.remove();
        }
        for (Map.Entry<Integer, Integer> m : map.entrySet()) {
            System.out.println(m.getKey());
        }
    }
}