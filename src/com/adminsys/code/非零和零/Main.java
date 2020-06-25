package com.adminsys.code.非零和零;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: qiang
 * @Description:
 * @Create: 2020-03-28 02-54
 **/

public class Main {
    public static void main(String[] args) {
        int[] arr = {3, 0, 0, 5, 7, 0};
        Queue<Integer> queue = new LinkedList<>();
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            if(arr[i] != 0){
                queue.add(arr[i]);
            }
        }
        for (int i = 0; i < len; i++) {
            if (!queue.isEmpty()) {
                arr[i] = queue.poll();
            }else{
                arr[i] = 0;
            }
        }
        for (int i = 0; i < len; i++) {
            System.out.println(arr[i]);
        }
    }
}
