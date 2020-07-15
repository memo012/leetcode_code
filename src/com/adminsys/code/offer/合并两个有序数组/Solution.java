package com.adminsys.code.offer.合并两个有序数组;

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int mtail = m - 1;
        int ntail = n - 1;
        int tail = m + n - 1;
        while (ntail >= 0) {
            if (mtail >= 0 && nums1[mtail] > nums2[ntail]) nums1[tail--] = nums1[mtail--];
            else nums1[tail--] = nums2[ntail--];
        }
    }
}