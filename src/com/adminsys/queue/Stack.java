package com.adminsys.queue;

/**
 * @Author: qiang
 * @Description:
 * @Create: 2020-02-06 13-39
 **/
class Node<E> {
    Node<E> next = null;
    E data;
    public Node(E data) {
        this.data = data;
    }
}



public class Stack<E> {
    Node<E> top = null;
    public Boolean Empty(){
        return this.top == null;
    }
    public void push(E e) {
        Node<E> node = new Node<>(e);
        node.next = top;
        top = node;
    }
    public E pop(){
        if(this.Empty()){
            return null;
        }
        E result = top.data;
        top = top.next;
        return result;
    }
    public E peek(){
        if(this.Empty()){
            return null;
        }
        return top.data;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
