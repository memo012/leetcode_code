package com.adminsys.负载均衡.轮询;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: qiang
 * @Description: 轮询算法
 * @Create: 2020-04-05 12-55
 **/

public class SelectMessage {

    private static AtomicInteger atomicInteger = new AtomicInteger();
    private static List<String> list;

    static {
        list = new LinkedList<>();
        list.add("8080");
        list.add("8081");
    }
    public void getSelectStrategy() {
        int value = atomicInteger.get() % list.size();
        atomicInteger.incrementAndGet();
        System.out.println(list.get(value));
    }
    public static void main(String[] args) {
        SelectMessage select = new SelectMessage();
        for (int i = 0; i < 5; i++) {
            select.getSelectStrategy();
        }
    }
}