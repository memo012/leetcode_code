package com.adminsys.code.反转链表;
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode node = head;
        ListNode newNode = head;
        ListNode preNode = null;
        while(node != null){
            ListNode nextNode = node.next;
            if(nextNode == null) {
                newNode = node;
            }
            node.next = preNode;
            preNode = node;
            node = nextNode;
        }
        head = newNode;
        return head;
    }
}