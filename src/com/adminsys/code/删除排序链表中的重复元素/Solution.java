package com.adminsys.code.删除排序链表中的重复元素;

import java.util.HashMap;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {

    /**
     * 实现思路
     * 遍历链表 定义一个辅助链表 如果与当前值相同 那么需要执行辅助链表往后移 直到链表为空
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode oldNode = head;
        if (head == null) {
            return null;
        }
        while (oldNode != null) {
            ListNode nextNode = oldNode;
            while (nextNode != null && nextNode.val == oldNode.val) {
                nextNode = nextNode.next;
            }
            if (nextNode == null) {
                oldNode.next = null;
                break;
            } else {
                oldNode.next = nextNode;
                oldNode = nextNode;
            }
        }
        return head;
    }

    public ListNode deleteDuplicates1(ListNode head) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ListNode newHead = head;
        ListNode reverseHead = null;
        while (newHead != null) {
            if (map.containsKey(newHead.val)) {
                reverseHead.next = newHead.next;
            } else {
                map.put(newHead.val, 1);
                reverseHead = newHead;
            }
            newHead = newHead.next;
        }
        return head;
    }

    /**
     *  在一个排序的链表中 存在重复的结点
     *  请删除该链表中重复的结点 重复的结点不保留 返回链表头指针
     *  例如 链表1->2->3->3->4->4->5 处理后为 1->2->5
     * @param pHead
     * @return
     */
    public ListNode deleteDuplication(ListNode pHead) {
        ListNode head = new ListNode(-1);
        head.next = pHead;
        ListNode pre = head;
        ListNode cur = pHead;
        while (cur != null) {
            if (cur.next != null && cur.val == cur.next.val) {
                cur = cur.next;
                while (cur.next != null && cur.val == cur.next.val) cur = cur.next;
                cur = cur.next;
                pre.next = cur;
            }else {
                pre = cur;
                cur = cur.next;
            }
        }
        return head.next;
    }

}