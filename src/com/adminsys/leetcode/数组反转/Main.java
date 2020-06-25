package com.adminsys.leetcode.数组反转;

import com.adminsys.queue.Stack;

import java.util.Arrays;

/**
 * @Author: qiang
 * @Description: 数组反转
 * @Create: 2020-02-14 07-45
 **/

public class Main {
    public static void main(String[] args) {
        int[] arr = {4, 5, 7, 2, 67};
        Main.reverseArr2(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void reverseArr2(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
    }

    public static void reverseArrStack(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            stack.push(arr[i]);
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = stack.pop();
        }
    }

}
