package com.adminsys.queue;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

/**
 * @Author: qiang
 * @Description: 两个队列实现一个堆
 * @Create: 2020-02-06 13-17
 **/

public class QueueAndStack<E> {

    private Stack<E> stack1 = new Stack<>();
    private Stack<E> stack2 = new Stack<>();

    private Queue<E> queue = new PriorityQueue<>();

    /**
     *  入队列
     * @param e
     */
    public void add(E e){
        stack1.push(e);
    }

    /**
     *  出队列
     * @return
     */
    public synchronized E pop(){
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public static void main(String[] args) {
        QueueAndStack<Integer> queue = new QueueAndStack<>();
        queue.add(1);
        queue.add(2);
        System.out.println("队列首元素:" + queue.pop());
        System.out.println("队列首元素:" + queue.pop());
        System.out.println("队列首元素:" + queue.pop());
    }

}
