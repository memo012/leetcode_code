package com.adminsys.猿辅导.素数之和等于某值;

import java.util.*;

/**
 * @author Qiang
 * @version 1.0
 * @description TODO
 * @date 2020/7/31 下午7:40
 **/
public class Solution {

    public boolean isSuShu(int num) {
        for (int i = 2; i <= num / 2; i++)
            if (num % i == 0) return false;
        return true;
    }

    public List<Integer> isSum(int num) {
        List<Integer> list = new ArrayList<>();
        for (int i = 2, j = num - 1; i < num / 2 || j > num / 2; ) {
            int sum = i + j;
            if (sum == num) {
                if (isSuShu(i) && isSuShu(j)) {
                    list.add(i);
                    list.add(j);
                    break;
                } else {
                    i++;
                    j--;
                }
            } else if (sum > num) j--;
            else i++;
        }
        return list;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        List<Integer> sum = new Solution().isSum(num);
        for (Integer in : sum) System.out.println(in);
    }
}
