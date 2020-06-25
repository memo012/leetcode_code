package com.adminsys.code.链表逆序;

/**
 * @Author: qiang
 * @Description:
 * @Create: 2020-02-24 10-09
 **/

class Node{
    int data;
    Node next;
    public Node(int data){
        this.data = data;
        this.next = null;
    }
}
public class Main {

    private Node head = null;

    public void insert(int data){
        Node node = new Node(data);
        if(head == null){
            head = node;
            return;
        }
        Node tmp = head;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        tmp.next = node;
    }

    private void printList() {
        Node tmp = head;
        while (tmp != null) {
            System.out.println(tmp.data);
            tmp = tmp.next;
        }
    }

    /**
     * 链表反转
     */
    public void reverseNode(){
        Node pre = head;
        Node reverse = head;
        Node node = null;
        while(pre != null){
            Node next = pre.next;
            if(next == null){
                reverse = pre;
            }
            pre.next = node;
            node = pre;
            pre = next;
        }
        this.head = reverse;
    }

    public static void main(String[] args) {
        Main list = new Main();
        for (int i = 0; i < 5; i++) {
            list.insert(i);
        }
        list.reverseNode();
        list.printList();
    }

}
