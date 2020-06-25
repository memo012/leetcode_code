package com.adminsys.code.删除在字符串中的字符;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @Author: qiang
 * @Description: 输入字符串A，B，将A中所有在B中也存在的字符删掉
 * @Create: 2020-04-06 21-15
 **/

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String strA = sc.nextLine();
        String strB = sc.nextLine();
        int slow = 0, fast = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < strB.length(); i++) {
            if (!map.containsKey(strB.charAt(i))) {
                map.put(strB.charAt(i), 1);
            }
        }
        for (int i = 0; i < strA.length(); i++) {
            if (map.containsKey(strA.charAt(i))) {
                fast++;
            }else {
                strA = strA.replace(strA.charAt(slow), strA.charAt(fast));
                slow++;
                fast++;
            }
        }
    }
}
