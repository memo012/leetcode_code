package com.adminsys.猿辅导.数组交集并集;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author: qiang
 * @Description:
 * @Create: 2020-06-03 21-01
 **/

public class Solution {

    /**
     * 并集
     *
     * @param a
     * @param b
     * @return
     */
    public int[] getB(int[] a, int[] b) {
        Set<Integer> set1 = new HashSet<>();
        for (Integer in : a) {
            set1.add(in);
        }
        Set<Integer> set2 = new HashSet<>();
        for (Integer in : b) {
            if (set1.contains(in)) {
                set2.add(in);
            }
        }
        int[] res = new int[set2.size()];
        int index = 0;
        for (Integer in : set2) {
            res[index++] = in;
        }
        return res;
    }

    /**
     * 交集
     *
     * @param a
     * @param b
     * @return
     */
    public int[] getJ(int[] a, int[] b) {
        Set<Integer> set1 = new HashSet<>();
        for (Integer in : a) {
            set1.add(in);
        }
        Set<Integer> set2 = new HashSet<>();
        for (Integer in : b) {
            set2.add(in);
        }
        set2.addAll(set1);
        int[] res = new int[set2.size()];
        int index = 0;
        for (Integer in : set2) {
            res[index++] = in;
        }
        return res;
    }


}
