package com.adminsys.猿辅导.链表m到n反转;


/**
 * @Author: qiang
 * @Description:
 * @Create: 2020-06-02 21-05
 **/
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
public class Solution {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode node = head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode firstNode = dummy;
        ListNode secondNode = dummy;

        for (int i = 0; i < m - 1; i++) {
            firstNode = firstNode.next;
        }
        for (int i = 0; i < n; i++) {
            secondNode = secondNode.next;
        }
        ListNode newFirst = firstNode.next;
        ListNode newSecond = secondNode.next;

        ListNode p1 = newFirst;
        ListNode p2 = p1.next;

        while (p1 != secondNode) {
            ListNode p = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = p;
        }

        firstNode.next = secondNode;
        newFirst.next = newSecond;
        return dummy.next;
    }

}
