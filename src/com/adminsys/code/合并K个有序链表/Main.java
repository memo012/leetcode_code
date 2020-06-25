package com.adminsys.code.合并K个有序链表;

import java.util.PriorityQueue;

/**
 * @Author: qiang
 * @Description:
 * @Create: 2020-04-04 08-59
 **/
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Main {
    public static void main(String[] args) {

    }

    /**
     * 最小堆思想  首先会把K个链表的头节点放入优先队列中，遍历时返回队首元素，并把该队
     * 首元素的下一个节点放入优先队列中，直至优先队列为空
     * @param listNodes
     * @return
     */
    public ListNode mergeKLists(ListNode[] listNodes) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>();
        for (int i = 0; i < listNodes.length; i++) {
            if (listNodes[i] != null) {
                queue.add(listNodes[i]);
            }
        }
        if (queue.isEmpty()) {
            return null;
        }
        ListNode temp = new ListNode(queue.peek().val);
        ListNode head = temp;
        while (!queue.isEmpty()) {
            ListNode mid = queue.poll();
            temp.next = mid;
            temp = temp.next;
            if (mid.next != null) {
                queue.offer(mid.next);
            }
        }
        return head.next;
    }
}