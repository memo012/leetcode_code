package com.adminsys.link;

import java.util.HashMap;
/**
 * @Author: qiang
 * @Description:
 * @Create: 2020-02-02 12-51
 **/

class Node {
    Node next; // 指向下一个节点
    int data; // 数据

    public Node(int data) {
        this.data = data;
    }
}

public class LinkedNode {

    /**
     * 头结点
     */
    private Node head = null;

    /**
     * 向链表中添加元素
     */
    private void addNode(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node tmp = head;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        tmp.next = newNode;
    }


    /**
     * 删除排序链表中的重复元素
     *
     * @param head
     * @return
     */
    public Node deleteDuplicates(Node head) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Node newHead = head;
        Node reverseHead = null;
        while (newHead != null) {
            if (map.containsKey(newHead.data)) {
                reverseHead.next = newHead.next;
            } else {
                map.put(newHead.data, 1);
                reverseHead = newHead;
            }
            newHead = newHead.next;
        }
        return head;
    }

    /**
     * 链表反转
     */
    public void reversedNode() {
        Node reverseNode = head;
        Node preNode = head;
        Node node = null;
        while (preNode != null) {
            Node nextNode = preNode.next;
            if (nextNode == null) {
                reverseNode = preNode;
            }
            preNode.next = node;
            node = preNode;
            preNode = nextNode;
        }
        this.head = reverseNode;
        System.out.println();
    }

    private void printList() {
        Node tmp = head;
        while (tmp != null) {
            System.out.println(tmp.data);
            tmp = tmp.next;
        }
    }


    public static void main(String[] args) {
        LinkedNode list = new LinkedNode();
        for (int i = 0; i < 5; i++) {
            list.addNode(i);
        }
        list.reversedNode();
        list.printList();
    }

}
