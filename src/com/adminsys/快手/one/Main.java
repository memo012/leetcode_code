package com.adminsys.快手.one;

import java.util.Scanner;
import java.util.Stack;

/**
 * @Author: qiang
 * @Description:
 * @Create: 2020-04-12 08-01
 **/

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n = sc.next();
        Stack<Character> stack = new Stack<>();
        char c1 = '(';
        char c2 = ')';
        int l1 = 0, l2 = 0, l3 = 0;
        for (int i = 0; i < n.length(); i++) {
            char c3 = n.charAt(i);
            if (c3 == '(') {
                stack.push(c3);
            } else if (c3 == ')') {
                if (stack.isEmpty()) {
                    stack.push(c3);
                    continue;
                }
                char c4 = stack.peek();
                if (c4 == '(') {
                    l1++;
                    stack.pop();
                } else {
                    stack.push(c4);
                }
            }
        }
        while (!stack.isEmpty()) {
            char c3 = stack.pop();
            if (c3 == '(') {
                l2++;
            } else {
                l3++;
            }
        }
        System.out.println(l1 + " " + l2 + " " + l3);

    }
}
