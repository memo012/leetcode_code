package com.adminsys.code.相交链表;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution {
    /**
     * 思路 用两个指针分别从两个链表头部开始扫描 每次分别走一步
     * 如果指针走到null时，则从另一个链表头部开始走
     * 当两个指针相同时
     * 如果指针不是null，则指针位置就是相遇点
     * 如果指针为空，则两个链表不相交
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p = headA;
        ListNode q = headB;
        while (p != q) {
            if (p != null) {
                p = p.next;
            } else {
                p = headB;
            }
            if (q != null) {
                q = q.next;
            } else {
                q = headA;
            }
        }
        return p;
    }
}