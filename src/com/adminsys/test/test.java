package com.adminsys.test;

import java.util.LinkedList;

/**
 * @Author: qiang
 * @Description:
 * @Create: 2020-06-05 17-53
 **/

public class test {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.addFirst(1);
        list.addFirst(2);
        list.forEach(System.out::println);
    }
}
