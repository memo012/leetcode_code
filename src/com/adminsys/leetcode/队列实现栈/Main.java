package com.adminsys.leetcode.队列实现栈;

import java.util.LinkedList;

/**
 * @Author: qiang
 * @Description:
 * @Create: 2020-02-24 02-17
 **/

public class Main {

    /**
     * 入栈
     */
    static LinkedList<Integer> queue1 = new LinkedList<>();
    /**
     * 出栈
     */
    static LinkedList<Integer> queue2 = new LinkedList<>();

    public static void add(int data) {
        if (queue1.isEmpty() && queue2.isEmpty()) {
            queue1.add(data);
        } else if (!queue1.isEmpty()) {
            queue1.add(data);
        } else if (!queue2.isEmpty()) {
            queue2.add(data);
        }
    }

    public static Integer pop() {
        Integer element;
        // 列队为空，抛出异常
        if (queue1.isEmpty() && queue2.isEmpty()) {
            return -1;
        }
        if (queue2.isEmpty()) {
            while (queue1.size() != 1) {
                queue2.add(queue1.pop());
            }
            element = queue1.pop();
        } else {
            while (queue2.size() != 1) {
                queue1.add(queue2.pop());
            }
            element = queue2.pop();
        }
        return element;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            Main.add(i);
        }
        for (int i = 0; i < 5; i++) {
            System.out.println(Main.pop());
        }
        Main.add(7);
        System.out.println(Main.pop());
    }

}
