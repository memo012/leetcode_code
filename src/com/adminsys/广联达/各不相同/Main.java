package com.adminsys.广联达.各不相同;

/**
 * @author Qiang
 * @version 1.0
 * @description TODO
 * @date 2020/9/9 下午7:41
 **/

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] num = new int[n];
        for (int i = 0; i < n; i++) num[i] = sc.nextInt();
        TreeSet<Integer> ts = new TreeSet<>((x, y) -> y-x);
        for (Integer i : num) {
            boolean flag = ts.add(i);
            int temp;
            while (!flag) {
                ts.remove(i);
                temp = i * 2;
                flag = ts.add(temp);
            }
        }
        for (Integer in : ts) {
            System.out.print(in + " ");
        }
    }

}
