package com.adminsys.code.offer.面试题24反转链表;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode node = head;
        ListNode newNode = head;
        while (node != null) {
            ListNode next = node.next;
            if (next == null) {
                newNode = node;
            }
            node.next = pre;
            pre = node;
            node = next;
        }
        return newNode;
    }
}