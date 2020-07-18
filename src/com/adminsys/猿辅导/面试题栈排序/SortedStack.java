package com.adminsys.猿辅导.面试题栈排序;

import java.util.Stack;

class SortedStack {
    Stack<Integer> stack;

    public SortedStack(){
        stack = new Stack<>();
    }

    public void push(int val) {
        Stack<Integer> temp = new Stack<>();
        while (!stack.isEmpty()) {
            if (stack.peek() < val) temp.push(stack.pop());
            else break;
        }
        stack.push(val);
        while (!temp.isEmpty()) stack.push(temp.pop());
    }

    public void pop() {
        if (stack.isEmpty()) return;
        stack.pop();
    }

    public int peek() {
        if (stack.isEmpty()) return -1;
        return stack.peek();
    }

    public boolean isEmpty() {
        return stack.size() == 0;
    }

}