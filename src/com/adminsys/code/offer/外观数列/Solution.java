package com.adminsys.code.offer.外观数列;

class Solution {
    public String countAndSay(int n) {
        if (n == 1) return "1";
        String res = "1";
        for (int k = 2; k <= n; k++) {
            StringBuilder sb = new StringBuilder();
            int pre = 0;
            int i = 0;
            for (i = 0; i < res.length(); i++) {
                if (res.charAt(pre) != res.charAt(i)) {
                    sb.append(i - pre).append(res.charAt(pre));
                    pre = i;
                }
            }
            sb.append(i - pre).append(res.charAt(pre));
            res = sb.toString();
        }
        return res;
    }
}