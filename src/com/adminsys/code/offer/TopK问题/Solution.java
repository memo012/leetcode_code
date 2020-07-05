package com.adminsys.code.offer.TopK问题;

import com.adminsys.多线程.blockingqueue.Queue;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @Author: qiang
 * @Description:
 * @Create: 2020-06-23 20-26
 **/

public class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        // 最后一个参数表示我们要找的是下标为k-1的数
        return quickSearch(arr, 0, arr.length - 1, k - 1);
    }

    /**
     * 使用快排解决TopK问题
     *
     * @param arr
     * @param start
     * @param end
     * @param k
     * @return
     */
    private int[] quickSearch(int[] arr, int start, int end, int k) {
        int index = quickSort(arr, start, end);
        if (index == k) return Arrays.copyOf(arr, index + 1);
        return index > k ? quickSearch(arr, start, index - 1, k) : quickSearch(arr, index + 1, end, k);
    }

    private int quickSort(int[] arr, int start, int end) {
        int i = start;
        int j = end;
        int temp = arr[start];
        while (i != j) {
            while (i < j && arr[j] >= temp) j--;
            while (i < j && arr[i] <= temp) i++;
            if (i != j) {
                int mid = arr[i];
                arr[i] = arr[j];
                arr[j] = mid;
            }
        }
        arr[start] = arr[i];
        arr[i] = temp;
        return i;
    }

    /**
     * 最大堆问题
     *
     * @param arr
     * @param k
     * @return
     */
    private int[] heapSort(int[] arr, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>((o1, o2) -> o1 - o2);
        for (int i : arr) {
            if (queue.size() < k) queue.offer(i);
            else if (queue.peek() < i) {
                queue.poll();
                queue.offer(i);
            }
        }
        int[] res = new int[queue.size()];
        int idx = 0;
        for (int num : queue) {
            res[idx++] = num;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 156, 5, 6, 8, 9, 16, 4};
        int[] a = new Solution().heapSort(arr, 3);
        for (int i = 0; i < 3; i++)
            System.out.println(a[i]);
    }


}
