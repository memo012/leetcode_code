package com.adminsys.code.奇在前偶在后;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: qiang
 * @Description:
 * @Create: 2020-03-29 03-24
 **/

public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 4, 5, 8, 3};
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                list2.add(arr[i]);
            } else {
                list1.add(arr[i]);
            }
        }
        Collections.sort(list1);
        Collections.sort(list2);
        int i = 0, j = 0;
        while (i < list1.size()) {
            arr[i] = list1.get(i++);
        }
        while (j < list2.size()) {
            arr[i++] = list2.get(j++);
        }
        for (i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "->");
        }
    }
}
