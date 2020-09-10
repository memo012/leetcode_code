package com.adminsys.微盟.three;

/**
 * @author Qiang
 * @version 1.0
 * @description TODO
 * @date 2020/9/6 下午5:06
 **/
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().sum(1));
    }
    public long sum (long n) {
        // write code here
        long r = 0;
        boolean flag = false;
        long a = 0;
        flag = (n!=0)&&(a==(r=sum(n-1)));
        return r + n;
    }
}
