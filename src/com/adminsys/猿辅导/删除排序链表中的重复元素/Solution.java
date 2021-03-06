package com.adminsys.猿辅导.删除排序链表中的重复元素;

import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }

}
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
       ListNode cur = head;

       while (cur != null && cur.next != null) {
           if (cur.val == cur.next.val) {
               cur.next = cur.next.next;
           }else {
               cur = cur.next;
           }
       }
       return head;
    }
}