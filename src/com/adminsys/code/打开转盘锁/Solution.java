package com.adminsys.code.打开转盘锁;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Solution {

    public String plusOper(String s, int i) {
        char[] ch = s.toCharArray();
        if (ch[i] == '9') 
            ch[i] = '0';
        else 
            ch[i] += 1;
        return new String(ch);
    }

    public String minOPer(String s, int i) {
        char[] ch = s.toCharArray();
        if (ch[i] == '0') 
            ch[i] = '9';
        else 
            ch[i] -= 1;
        return new String(ch);
    }

    public int openLock(String[] deadends, String target) {

        Set<String> deads = new HashSet<>();
        for (String dead : deadends) deads.add(dead);

        Queue<String> queue = new LinkedList<>();
        Set<String> use = new HashSet<>();
        queue.add("0000");
        use.add("0000");

        int count = 0;
        while(!queue.isEmpty()) {
            int width = queue.size();
            for (int i = 0; i < width; i++) {
                String mid = queue.poll();
                if (deads.contains(mid)) continue;
                if (mid.equals(target)) {
                    return count;
                }

                for (int j = 0; j < 4; j++) {
                    String up = plusOper(mid, j);
                    if (!use.contains(up)) {
                        queue.add(up);
                        use.add(up);
                    }
                    String down = minOPer(mid, j);
                    if (!use.contains(down)) {
                        queue.add(down);
                        use.add(down);
                    }
                }
            }
            count++;
        }

        return -1;
    }
}