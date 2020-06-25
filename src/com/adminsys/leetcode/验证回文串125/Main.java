package com.adminsys.leetcode.验证回文串125;

/**
 * @Author: qiang
 * @Description:
 * @Create: 2020-02-07 08-36
 **/

public class Main {
    public boolean isPalindrome(String s) {
        StringBuffer stringBuffer = new StringBuffer();
        s = s.toLowerCase();
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if((temp >= 'a' && temp <= 'z') || (temp >= '0' && temp <= '9')){
                stringBuffer.append(temp);
            }
        }
        String str = stringBuffer.toString();
        String reverse = stringBuffer.reverse().toString();
        if(reverse.equals(str)){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String str = "race a car";
        Main main = new Main();
        System.out.println(main.isPalindrome(str));

    }
}
