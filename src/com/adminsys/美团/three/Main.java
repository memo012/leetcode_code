package com.adminsys.美团.three;

import com.sun.javafx.binding.StringFormatter;

import java.util.*;

/**
 * @Author: qiang
 * @Description:
 * @Create: 2020-04-02 11-28
 **/
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        double[] arr = new double[n];
        int[] num = new int[n];
        Map<Integer, Double> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextDouble();
            map.put(i, arr[i]);
        }
        for (int i = 0; i < n; i++) {
            num[i] = in.nextInt();
        }
        Arrays.sort(arr);
        int k = 0;
        double sum = 0;
        for (int i = 0; i < n; ) {
            if (map.get(i) == arr[n - 1]) {
                k = i;
                break;
            } else {
                i++;
            }
        }
        double t = 1;
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                t *= num[k] * arr[n - 1];
            } else {
                t *= arr[n - 1];
            }
            sum += t;
        }
        System.out.println(String.format("%.2f", sum));
    }
}