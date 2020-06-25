package com.adminsys.code.单词接龙;

import javafx.util.Pair;
import java.util.*;

/**
 * 单词接龙
 * 将问题抽象成一个无向无权图 每个单词作为一个节点 差距只有一个字母的两个单词连在一边
 */
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int length = beginWord.length();

        Map<String, List<String>> map = new HashMap<>();

        // 预处理
        wordList.forEach(
                word -> {
                    for (int i = 0; i < length; i++) {
                        String newWord = word.substring(0, i) + "*" + word.substring(i + 1, length);
                        List<String> list = map.getOrDefault(newWord, new ArrayList<>());
                        list.add(word);
                        map.put(newWord, list);
                    }
                }
        );

        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(beginWord, 1));

        Map<String, Boolean> flag = new HashMap<>();
        flag.put(beginWord, true);

        while (!queue.isEmpty()) {
            Pair<String, Integer> pair = queue.poll();
            String key = pair.getKey();
            Integer value = pair.getValue();
            for (int i = 0; i < length; i++) {
                String newWord = key.substring(0, i) + "*" + key.substring(i + 1, length);
                for (String adjustWord : map.getOrDefault(newWord, new ArrayList<>())) {
                    if (adjustWord.equals(endWord)) {
                        return value + 1;
                    }
                    if (!flag.containsKey(adjustWord)) {
                        flag.put(adjustWord, true);
                        queue.add(new Pair<>(adjustWord, value + 1));
                    }
                }
            }
        }
        return 0;
    }
}