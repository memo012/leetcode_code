package com.adminsys.code.反转链表2;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {

    /**
     * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
     * <p>
     * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
     * 输出: 1->4->3->2->5->NULL
     * <p>
     * 思路： 首先确定m-1的位置和m的位置和n的位置和n-1的位置
     * 然后把m-n之间的位置互换即可
     *
     * @param head
     * @param m
     * @param n
     * @return
     */

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode firstNode = dummy;
        ListNode secondNode = dummy;

        // m-1
        for (int i = 0; i < m - 1; i++) {
            firstNode = firstNode.next;
        }
        // m
        ListNode newFirstNode = firstNode.next;
        // n
        for (int i = 0; i < n; i++) {
            secondNode = secondNode.next;
        }
        // n+1
        ListNode newSecondNode = secondNode.next;

        ListNode p1 = newFirstNode;
        ListNode p2 = p1.next;
        while (p1 != secondNode) {
            ListNode p = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = p;
        }

        firstNode.next = secondNode;
        newFirstNode.next = newSecondNode;
        return dummy.next;
    }

    /**
     *
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode reverseBetween1(ListNode head, int m, int n) {
        if(m == n){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode firstNode = dummy;
        for(int i = 0; i < m - 1; i++){
            firstNode = firstNode.next;
        }
        ListNode a = firstNode;
        ListNode b = a.next;
        ListNode c = b.next;
        for(int i = m + 1; i <= n; i++){
            ListNode d = c.next;
            c.next = b;
            b = c;
            c = d;
        }
        // 将 m 的 next 指向 n 指针的 next, 同时将排在 m 前面一位的指针的 next 指向 n
        a.next.next = c;
        a.next = b;
        return dummy.next;
    }
}