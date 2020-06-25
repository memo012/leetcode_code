package com.adminsys.leetcode.数组中重复的数字;

import java.util.HashMap;

/**
 * @Author: qiang
 * @Description:
 * @Create: 2020-02-11 12-55
 **/

public class Main {
    public static int repetitionNumber(int[] arr){
        int length = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            if(map.containsKey(arr[i])){
                return arr[i];
            }
            map.put(arr[i], arr[i]);
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 0, 2, 5, 3};
        System.out.println(repetitionNumber(arr));
    }
}
