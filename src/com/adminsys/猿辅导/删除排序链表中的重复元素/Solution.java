package com.adminsys.猿辅导.删除排序链表中的重复元素;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode node = new ListNode(-1);
        ListNode tail = node;
        ListNode left = head;
        ListNode right = head;
        while (left != null) {
            while (right != null && left.val == right.val) right = right.next;
            if (left.next == right) {
                tail.next = left;
                tail = left;
                tail.next = null;
            }
            left = right;
        }
        return node.next;
    }
}