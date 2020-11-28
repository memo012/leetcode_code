package com.adminsys.code.offer.找到字符串的最长无重复字符子串;

/**
 * @author Qiang
 * @version 1.0
 * @description TODO
 * @date 2020/9/21 下午5:06
 **/
import java.util.*;
public class Solution {

    /**
     *
     * @param arr int整型一维数组 the array
     * @return int整型
     */
    public int maxLength (int[] arr) {
        // write code here
        LinkedList<Integer> list = new LinkedList<>();
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            if (list.contains(arr[i])) {
                int j = list.indexOf(arr[i]);
                while (j-- >= 0) list.removeFirst();
            }
            list.add(arr[i]);
            ans = Math.max(ans, list.size());
        }
        return ans;
    }

}
