package com.adminsys.猿辅导.找到K个最接近的元素;

import java.util.*;

class Solution {
    /**
     * 最大堆思想
     *
     * @param arr
     * @param k
     * @param x
     * @return
     */
    public List<Integer> findClosestElementsTwo(int[] arr, int k, int x) {

        if (arr == null || arr.length == 0 || k == 0) return new ArrayList<>();

        PriorityQueue<Node> queue =
                new PriorityQueue<Node>((o1, o2) -> o2.y - o1.y);
        for (int i = 0; i < arr.length; i++) {

            if (queue.isEmpty() || queue.size() < k) {
                queue.offer(new Node(arr[i], Math.abs(arr[i] - x)));
                continue;
            }

            int mn = Math.abs(arr[i] - x);
            int mo = queue.peek().y;
            if (mo > mn) queue.poll();
            else continue;
            queue.offer(new Node(arr[i], mn));
        }

        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            list.add(0, queue.poll().x);
        }
        Collections.sort(list);
        return list;
    }

    class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        int left = 0;
        int length = arr.length;
        int right = arr.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (mid + k >= length || Math.abs(arr[mid] - x) <= Math.abs(arr[mid + k] - x)) right = mid;
            else left = mid + 1;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = left; i < left + k; i++)
            list.add(arr[i]);
        return list;

    }

}