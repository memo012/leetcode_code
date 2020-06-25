package com.adminsys.code.获取你好友已观看的视频;

import java.util.*;

class Solution {

    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(id);
        List<String> remain = new ArrayList<>();
        int n = friends.length;
        boolean[] use = new boolean[n];
        use[id] = true;

        // 队列中存储的为level层的好友ID
        for (int i = 0; i < level; i++) {
            int width = queue.size();
            for (int j = 0; j < width; j++) {
                int mid = queue.poll();
                for (int v : friends[mid]) {
                    if (!use[v]) {
                        use[v] = true;
                        queue.add(v);
                    }
                }
            }
        }

        Map<String, Integer> map = new TreeMap<>((o1, o2) -> o1.compareTo(o2));
        while (!queue.isEmpty()) {
            int mid = queue.poll();
            for (String ls : watchedVideos.get(mid)) {
                map.put(ls, map.getOrDefault(ls, 0) + 1);
            }
        }

        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(map.entrySet());
        entryList.sort((o1, o2) -> o1.getValue() - o2.getValue());

        for (Map.Entry<String, Integer> m : entryList) {
            remain.add(m.getKey());
        }

        return remain;
    }
}