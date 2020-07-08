package com.adminsys.code.整数反转;

/**
 * @author Qiang
 * @version 1.0
 * @description TODO
 * @date 2020/7/8 下午11:07
 **/
public class Solution {
    public int reverse(int x) {
        int ans = 0;
        while (x != 0) {
            int pop = x % 10;
            if (ans > Integer.MAX_VALUE || (ans == Integer.MAX_VALUE && pop > 7))
                return 0;
            if (ans < Integer.MIN_VALUE || (ans == Integer.MIN_VALUE && pop < -8))
                return 0;
            ans = ans * 10 + pop;
            x /= 10;
        }
        return ans;
    }
}
