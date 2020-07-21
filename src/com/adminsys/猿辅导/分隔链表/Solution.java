package com.adminsys.猿辅导.分隔链表;


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode firstNode = new ListNode(-1);
        ListNode afterNode = new ListNode(-1);
        ListNode low = firstNode;
        ListNode tail = afterNode;
        ListNode node = head;
        while (node != null) {
            if (node.val < x) {
                low.next = node;
                low = low.next;
            } else {
                tail.next = node;
                tail = tail.next;
            }
            node = node.next;
        }
        tail.next = null;
        low.next = afterNode.next;
        return firstNode.next;
    }
}