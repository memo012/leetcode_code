package com.adminsys.猿辅导.找出来数组中每个元素后边第一个比它大的值;

import java.util.Stack;

/**
 * @Author: qiang
 * @Description: 找出来数组中每个元素后边第一个比它大的值
 * @Create: 2020-06-03 22-17
 **/

public class Solution {

    public int[] findMaxRight(int[] arr) {
        if (arr == null) {
            return null;
        }
        Stack<Integer> stack = new Stack<>();
        stack.add(0);
        int index = 1;
        int size = arr.length;
        int[] result = new int[size];
        while (index < size) {
            if (!stack.isEmpty() && arr[index] > arr[stack.peek()]) {
                result[stack.pop()] = arr[index];
            }else {
                stack.push(index);
                index++;
            }
        }
        if (!stack.isEmpty()) {
            result[stack.pop()] = -1;
        }
        return result;
    }
}
