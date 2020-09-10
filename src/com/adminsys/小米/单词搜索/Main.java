package com.adminsys.小米.单词搜索;

/**
 * @author Qiang
 * @version 1.0
 * @description TODO
 * @date 2020/9/8 下午6:49
 **/

import java.util.*;

public class Main {
    static char[][] map = new char[][]{
            {'A', 'B', 'C', 'E'},
            {'S', 'F', 'C', 'S'},
            {'A', 'D', 'E', 'E'}
    };
    static int[][] next = new int[][]{
            {0, 1},
            {1, 0},
            {0, -1},
            {-1, 0}
    };
    static int[][] flag;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        flag = new int[map.length][map[0].length];
        System.out.println(exist(str));
    }

    public static boolean exist(String str) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == str.charAt(0)) {
                    flag[i][j] = 1;
                    if (exist(str, 1, i, j)) return true;
                    flag[i][j] = 0;
                }
            }
        }
        return false;
    }


    public static boolean exist(String word, int index, int x, int y) {
        if (index == word.length()) return true;
        for (int i = 0; i < next.length; i++) {
            int tx = x + next[i][0];
            int ty = y + next[i][1];
            if (tx < 0 || tx >= map.length || ty < 0 || ty >= map[0].length) continue;
            if (flag[tx][ty] == 0 && map[tx][ty] == word.charAt(index)) {
                flag[tx][ty] = 1;
                if (exist(word, index + 1, tx, ty)) return true;
                flag[tx][ty] = 0;
            }
        }
        return false;
    }
}
