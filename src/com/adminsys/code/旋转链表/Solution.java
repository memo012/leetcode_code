package com.adminsys.code.旋转链表;
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null){
            return null;
        }
        int len = 0;
        ListNode p = head;
        while (p != null){
            len++;
            p = p.next;
        }
        k %= len;
        if (k == 0) {
            return head;
        }
        ListNode first = head;
        ListNode second = head;
        while (k != 0){
            k--;
            first = first.next;
        }
        while (first.next != null){
            first = first.next;
            second = second.next;
        }
        first.next = head;
        head = second.next;
        second.next = null;
        return head;
    }
}