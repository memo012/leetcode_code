package com.adminsys.code.offer.lt52两个链表的第一个公共节点;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode node1 = headA;
        ListNode node2 = headB;
        int count = 0;
        while (node1 != node2) {
            node1 = node1.next;
            node2 = node2.next;
            if (node1 == null) {
                node1 = headB;
                count++;
            }
            if (node2 == null) {
                node2 = headA;
                count++;
            }
            if (count > 2) return null;
        }
        return node1;
    }
}