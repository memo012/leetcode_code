package com.adminsys.猿辅导.k个一组翻转链表;

/**
 * @author Qiang
 * @version 1.0
 * @description TODO
 * @date 2020/7/19 下午5:07
 **/


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode root = new ListNode(-1);
        root.next = head;
        ListNode pre = root;
        ListNode end = root;
        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++) end = end.next;
            if (end == null) break;
            ListNode start = pre.next;
            ListNode next = end.next;
            end.next = null;
            pre.next = reverse(start);
            start.next = next;
            pre = start;
            end = pre;
        }
        return root.next;
    }

    public ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        return pre;
    }

}
