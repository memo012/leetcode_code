package com.adminsys.猿辅导.栈实现队列;

import java.util.Stack;

/**
 * @Author: qiang
 * @Description: 栈实现队列
 * @Create: 2020-06-03 20-35
 **/

public class StackQueue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public StackQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void add(int element) {
        stack1.push(element);
    }

    public int poll() throws Exception {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        if (stack2.isEmpty()) {
            throw new Exception("Queue is empty.");
        }
        return stack2.pop();
    }

}
