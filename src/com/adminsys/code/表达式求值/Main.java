package com.adminsys.code.表达式求值;

import java.util.Scanner;
import java.util.Stack;

/**
 * @Author: qiang
 * @Description:
 * @Create: 2020-03-24 11-40
 **/

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(test(str));
    }

    public static String test(String str) {
        String[] split = str.split("\\s+");
        if (split.length % 2 == 0) {
            return "error";
        }
        Stack<String> stack1 = new Stack<>();
        boolean flag = false;
        boolean tmp = false;
        for (int i = 0; i < split.length; i++) {
            if (i % 2 == 0) {
                if (split[i].equals("or") || split[i].equals("and")) {
                    tmp = true;
                    break;
                }
                if (flag) {
                    if (split[i].equals("false") || stack1.peek().equals("false")) {
                        stack1.pop();
                        stack1.add("false");
                    }
                    flag = false;
                } else {
                    stack1.add(split[i]);
                }
            } else {
                if (split[i].equals("false") || split[i].equals("true")) {
                    tmp = true;
                    break;
                }
                if (split[i].equals("and")) {
                    flag = true;
                }
            }
        }
        if (tmp) {
            return "error";
        }
        if (stack1.contains("true")) {
            return "true";
        }
        return "false";
    }
}
