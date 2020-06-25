package com.adminsys.code.LRU;

import java.util.LinkedHashMap;
import java.util.Map;
/**
 * @Author: qiang
 * @Description:
 * @Create: 2020-03-29 03-40
 **/
class LRUCache extends LinkedHashMap<Integer, Integer> {

    private int capacity;

    public LRUCache(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}
public class Main {
    public static void main(String[] args) {
        LRUCache obj = new LRUCache(3);
        int param_1 = obj.get(1);
        obj.put(1, 2);
    }
}