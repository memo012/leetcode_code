package com.adminsys.code.课程表;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 思路：
 * 求是否可以完成全部课程等价于
 * 统计每个节点的入度和出度
 * 入度代表该节点依赖的节点个数  出度代表被依赖节点  用list集合表示(邻接表)
 * 将入度为0的节点加入队列中 遍历删除其他节点依赖的次数减一 若节点入度为0 再加入队列中
 */
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 节点的入度次数
        int[] courses = new int[numCourses];
        // 节点的出度
        List<List<Integer>> lists = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            lists.add(new ArrayList<>());
        }
        for (int[] course :
                prerequisites) {
            courses[course[0]]++;
            lists.get(course[1]).add(course[0]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (courses[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int pre = queue.poll();
            numCourses--;
            for (int cur :
                    lists.get(pre)) {
                if (--courses[cur] == 0) {
                    queue.add(cur);
                }
            }
        }
        return numCourses == 0;
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
// 节点的入度次数
        int[] courses = new int[numCourses];
        int[] result = new int[numCourses];
        int index = 0;
        // 节点的出度
        List<List<Integer>> lists = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            lists.add(new ArrayList<>());
        }
        for (int[] course :
                prerequisites) {
            courses[course[0]]++;
            lists.get(course[1]).add(course[0]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (courses[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int pre = queue.poll();
            numCourses--;
            result[index++] = pre;
            for (int cur :
                    lists.get(pre)) {
                if (--courses[cur] == 0) {
                    queue.add(cur);
                }
            }
        }
        return numCourses == 0 ? result : new int[]{};
    }

}