package com.adminsys.猿辅导.链表实现队列;

import java.util.NoSuchElementException;

/**
 * @Author: qiang
 * @Description: 链表实现队列
 * @Create: 2020-06-02 19-56
 **/

public class LinkedQueue<T> {

    private class Node {
        private Node next;
        private T element;

        public Node(T element, Node next) {
            this.element = element;
            this.next = next;
        }
    }

    private int size;
    private Node head;
    private Node tail;

    public LinkedQueue() {
        Node node = new Node(null, null);
        head = tail = node;
        size = 0;
    }

    public T add(T element) {
        Node node = new Node(element, null);
        tail.next = node;
        tail = node;
        size++;
        return element;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T poll() {
        if (isEmpty()) {
            throw new NoSuchElementException("队列为空");
        }
        T result;
        Node first = head.next;
        result = first.element;
        head.next = first.next;
        first.next = null;
        size--;
        return result;
    }

    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("队列为空");
        }
        return head.next.element;
    }

    @Override
    public String toString() {
        if (isEmpty()){
            return "[]";
        }
        StringBuilder sb=new StringBuilder("[");
        Node cursor=head.next;//指向第一个有意义的结点。
        for (int i=0;i<size;i++){
            sb.append(cursor.element.toString());
            if (i!=size-1){
                sb.append(",");
            }
            cursor=cursor.next;
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        LinkedQueue<String> q=new LinkedQueue<>();
        q.add("1");
        q.add("2");
        q.add("3");
        System.out.println(q);//[1,2,3]
        q.poll();
        q.poll();
        System.out.println(q);//[3]
        q.add("4");
        q.add("5");
        q.add("6");
        q.add("7");
        System.out.println(q);//[3,4,5,6,7]
    }

}
