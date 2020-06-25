package com.adminsys.code.重排链表;

import com.adminsys.queue.Stack;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        Stack<ListNode> stack = new Stack<>();
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            ListNode nextNode = fast.next.next;
            slow = slow.next;
            fast = nextNode;
        }
        // slow 表示中间结点
        ListNode pre = slow.next;
        ListNode pre1 = pre.next;
        while (pre != null){
            ListNode nextNode = pre1.next;
            pre1.next = pre;
            pre = pre1;
            pre1 = nextNode.next;
        }



    }
}