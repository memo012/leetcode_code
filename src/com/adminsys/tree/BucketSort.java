package com.adminsys.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: qiang
 * @Description: 桶排序
 * @Create: 2020-04-10 14-21
 **/

public class BucketSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m;
        int[] arr = new int[100];
        while (n-- > 0) {
            m = sc.nextInt();
            arr[m]++;
        }
        List<Integer> list = new ArrayList<>();
        bucketSort(arr, list);
        for (Integer i : list) {
            System.out.print(i + "->");
        }
    }

    public static void bucketSort(int[] arr, List<Integer> list) {
        // 1. 统计该值出现几次
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j <= arr[i]; j++) {
                list.add(i);
            }
        }
    }
}
