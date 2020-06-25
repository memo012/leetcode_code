package com.adminsys.code.offer.面试题18删除链表的节点;
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
class Solution {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode node = pre;
        while (true) {
            ListNode nextNext = node.next;
            if (nextNext == null) {
                return null;
            }
            if (nextNext.val == val) {
                node.next = nextNext.next;
                break;
            }
            node = node.next;
        }
        return pre.next;
    }
}