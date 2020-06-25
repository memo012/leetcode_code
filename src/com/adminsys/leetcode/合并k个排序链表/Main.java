package com.adminsys.leetcode.合并k个排序链表;

/**
 * @Author: qiang
 * @Description:
 * @Create: 2020-02-14 09-21
 **/
class Node{
    Node next; // 指向下一个节点
    int data; // 数据
    public Node(int data){
        this.data = data;
    }
}
public class Main {

    /**
     *   合并两个有序链表
     * @param l1
     * @param l2
     * @return
     */
    public Node mergeTwoLists(Node l1, Node l2) {
        if (l1 == null) {
            return l2;
        }
        else if (l2 == null) {
            return l1;
        }
        else if (l1.data < l2.data) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
