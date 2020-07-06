package com.adminsys.code.公交站间的距离;

class Solution {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        if (distance == null || distance.length == 0) return 0;
        int sum = 0, sum1 = 0;
        for (int i = 0; i < distance.length; i++) {
            sum += distance[i];
            if (i >= Math.min(start, destination) && i < Math.max(start, destination))
                sum1 += distance[i];
        }
        return Math.min(sum1, sum- sum1);
    }
}