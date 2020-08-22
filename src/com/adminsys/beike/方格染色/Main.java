package com.adminsys.beike.方格染色;

/**
 * @author Qiang
 * @version 1.0
 * @description TODO
 * @date 2020/8/11 下午7:18
 **/

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            long n = sc.nextLong();
            long m = sc.nextLong();
            for (int k = 2; k <= n * m; k++) {
                if ((n * m) % k == 0){
                    System.out.println(k);
                    break;
                }
            }
        }
    }
}