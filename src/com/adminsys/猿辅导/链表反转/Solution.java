package com.adminsys.猿辅导.链表反转;

/**
 * @Author: qiang
 * @Description:
 * @Create: 2020-06-03 21-11
 **/
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution {

    public ListNode reverseNode(ListNode root) {
        if (root == null) {
            return null;
        }
        ListNode preNode = null;
        ListNode node = root;
        ListNode head = root;
        while (node != null) {
            ListNode next = node.next;
            if (next == null) {
                head = node;
            }
            node.next = preNode;
            preNode = node;
            node = next;
        }
        return head;
    }

}
