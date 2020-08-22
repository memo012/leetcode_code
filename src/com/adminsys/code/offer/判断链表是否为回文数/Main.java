package com.adminsys.code.offer.判断链表是否为回文数;

/**
 * @author Qiang
 * @version 1.0
 * @description TODO
 * @date 2020/8/20 下午7:41
 **/
import java.util.*;





public class Main {
    class ListNode {
        int val;
        ListNode next = null;
    }
    /**
     * 判断是否为回文链表
     * @param head ListNode类 链表头
     * @return bool布尔型
     */
    public boolean isPalindrome (ListNode head) {
        // write code h
        int length = 0;
        ListNode root = head.next;
        while (root != null) {
            root = root.next;
            length++;
        }
        int[] datas = new int[length];
        int i = 0;
        for (ListNode temp = head.next; temp != null; temp = temp.next) {
            datas[i++] = temp.val;
        }
        boolean flag = true;
        for (int j = 0, k = length - 1; j < length / 2 && k >= length / 2; j++, k--)
            if (datas[j] != datas[k]) {
                flag = false;
                break;
            }
        return flag;
    }
}