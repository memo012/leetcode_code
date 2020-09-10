package com.adminsys.最后.构建二插搜索树;

/**
 * @author Qiang
 * @version 1.0
 * @description TODO
 * @date 2020/9/10 下午7:57
 **/

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n == 0) {
            System.out.println(0);
            return;
        }
        int[] te = new int[n + 1];
        te[0] = 1;
        te[1] = 1;
        for (int i = 2; i <= n; i++)
            for (int j = 1; j <= i; j++)
                te[i] += te[i - j] * te[j - 1];
        System.out.println(te[n]);
    }
}
