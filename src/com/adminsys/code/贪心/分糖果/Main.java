package com.adminsys.code.贪心.分糖果;

import java.util.Arrays;

/**
 * @Author: qiang
 * @Description:
 * @Create: 2020-03-01 09-13
 **/

public class Main {

    public int findContentChildren(int[] g, int[] s){
        Arrays.sort(g);
        Arrays.sort(s);
        int child = 0;// child代表了几个孩子
        int cookie = 0;
        while (child < g.length && cookie < s.length) {
            if(g[child] <= s[cookie]){
                child++;
            }
            cookie++;
        }
        return child;
    }
    public static void main(String[] args) {
        int[] g = {};
    }
}