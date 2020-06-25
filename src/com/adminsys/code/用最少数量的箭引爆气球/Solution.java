package com.adminsys.code.用最少数量的箭引爆气球;

import java.util.PriorityQueue;

/**
 *   x y
 *  首先根据x从小到大排序  若x相等  按Y从小到大排序
 *  等价于求两个区间的交集 start end
 *  如果上一个区间的end值大于新区间的start值 start 为两个区间start的最大值 end值为
 *  两个区间的最小值
 *  如果上一个区间的end值小于新区间的start值 为新的区间 sum++  start 为新区间start
 *  end为新区间end值
 */
class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        PriorityQueue<Point> priorityQueue = new PriorityQueue<>(
                (Point p1, Point p2) -> {
                    return p1.x.equals(p2.x) ? p1.y.compareTo(p2.x) : p1.x.compareTo(p2.x);
                }
        );
        for (int[] arr : points) {
            priorityQueue.add(new Point(arr[0], arr[1]));
        }
        Point point = priorityQueue.poll();
        int start = point.x;
        int end = point.y;
        int sum = 1;
        while (!priorityQueue.isEmpty()) {
            Point mid = priorityQueue.poll();
            if (end < mid.x){
                start = mid.x;
                end = mid.y;
                sum++;
            }else {
                start = Math.max(start, mid.x);
                end = Math.min(end, mid.y);
            }
        }
        return sum;
    }

    class Point {
        Integer x;
        Integer y;

        Point(Integer x, Integer y) {
            this.x = x;
            this.y = y;
        }
    }
}