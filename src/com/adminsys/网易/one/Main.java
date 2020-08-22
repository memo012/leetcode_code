package com.adminsys.网易.one;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: qiang
 * @Description:
 * @Create: 2020-04-11 19-44
 **/
import java.util.*;

public class Main {
    static int m;
    static int sum = 0;
    static List<List<Integer>> lists;

    public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);
            long n = sc.nextLong();
            long[] nums = new long[(int) n];
            int sum = 0;
            for (int i = 0; i < nums.length; i++) nums[i] = sc.nextLong();
            for (long l : nums) sum += l / 2;
            System.out.println(sum);
    }
}