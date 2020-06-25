package com.adminsys.快手.two;

import java.util.*;


public class Solution {
    /**
     * 返回无重复幂因子的 N进制完美数之和的所有幂因子
     *
     * @param R int整型
     * @param N int整型 N进制
     * @return int整型一维数组
     */
    private Map<Integer, Integer> map = new HashMap<>();

    public int[] GetPowerFactor(int R, int N) {
        // write code here
        if (R == 1) {
            return new int[]{0};
        }
        while (true) {
            R = pows(R, N);
            if (R == 0) {
                break;
            }
            if (R < N) {
                if (R == 1) {
                    map.put(R, map.getOrDefault(R, 0) + 1);
                    break;
                } else {
                    return new int[]{};
                }
            }
        }
        boolean flag = false;
        int index = 0;
        int[] arr = new int[map.size()];
        for (Map.Entry<Integer, Integer> mp :
                map.entrySet()) {
            int key = mp.getKey();
            int value = mp.getValue();
            if (value > 1) {
                flag = true;
                break;
            }
            arr[index++] = key;
        }
        if (flag) {
            return new int[]{};
        } else {
            Arrays.sort(arr);
            return arr;
        }
    }

    private int pows(int r, int n) {
        int sum = 1, count = 0;
        while (sum < r) {
            sum *= n;
            if (sum < r) {
                count++;
            }
        }
        if (count != 0) {
            map.put(count, map.getOrDefault(count, 0) + 1);
        }
        if (sum == r) {
            return 0;
        }
        sum /= n;
        return r - sum;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        String[] split = str.split(",");
        int R = Integer.valueOf(split[0]);
        int N = Integer.valueOf(split[1]);
        Solution s = new Solution();
        int[] ints = s.GetPowerFactor(R, N);
        for (Integer i :
                ints) {
            System.out.print(i + "->");
        }
    }
}