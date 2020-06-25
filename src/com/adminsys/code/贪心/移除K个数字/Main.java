package com.adminsys.code.贪心.移除K个数字;

import com.adminsys.queue.Stack;

/**
 * @Author: qiang
 * @Description:
 * @Create: 2020-03-01 10-20
 **/

public class Main {

    public static String removeKdigits(String num, int k){
        Stack<Integer> stack = new Stack<>();
        String result = "";
        for (int i = 0; i < num.length(); i++) {
            int number = num.charAt(i) - '0';
            while (!stack.Empty() && stack.peek() > number && k > 0){
                stack.pop();
                k--;
            }
            if (number != 0 || !stack.Empty()) {
                stack.push(number);
            }
        }
        // 如果栈不空，且仍然可以删除数字
        while (!stack.Empty() && k > 0){
            stack.pop();
            k--;
        }
        while (!stack.Empty()){
            result.indexOf(1, '0' + stack.pop());
        }
        if(result == ""){
            result = "0";
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(removeKdigits("1432219", 3));
    }

}
