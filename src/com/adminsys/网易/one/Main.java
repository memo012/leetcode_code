package com.adminsys.网易.one;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: qiang
 * @Description:
 * @Create: 2020-04-11 19-44
 **/

public class Main {
    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> objects = new ArrayList<>();
        List<Integer> objects1 = new ArrayList<>();
        List<Integer> object2 = new ArrayList<>();
        objects.add(1);
        objects1.add(2);
        objects1.add(5);
        object2.add(3);
        list.add(objects);
        list.add(objects1);
        list.add(object2);
        List<Integer> k = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).get(0) == 2) {
                k = list.get(i);
            }
        }
//        list.remove(k);
        for (List<Integer> i:
             list) {
            if(i.contains(2)){
                System.out.print(i.size());
            }
        }
    }
}
