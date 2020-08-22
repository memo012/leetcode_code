package com.adminsys.京东.one;

/**
 * @author Qiang
 * @version 1.0
 * @description TODO
 * @date 2020/8/6 下午7:48
 **/

import java.text.NumberFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = 1, i = 1;
        double sum = 0.0;
        while (i <= n) {
            double temp1 = k / (5.0 * (2.0 * n - 1));
            k = -k;
            double temp2 = k / (5.0 * 2 * i);
            sum += temp1 + temp2;
            i++;
        }
        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setMaximumFractionDigits(4);
        System.out.printf("%.4f", sum);
    }
}
