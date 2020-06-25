package com.adminsys.美团.按数字变化;

import java.util.Comparator;
import java.util.Scanner;

/**
 * @Author: qiang
 * @Description: 指定将整数中的某个数字按顺序变换为另一个数字
 * @Create: 2020-04-02 03-58
 **/

public class Main {
    static class comparator implements Comparator<Integer>{
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }
    public static String getString(String str, int[] arr) {
        if(str.length() == 0) {
            return "";
        }
        char[] chs = str.toCharArray();
        int i = 0;
        if(chs[0] == '-') {
            i = 1;
        }
        for(; i < chs.length; i++) {
            chs[i] = (char)(arr[chs[i] - '0' - 1] + '0');
        }
        return new String(chs);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] nums = new int[9];
        while (in.hasNext()) {
            String string = String.valueOf(in.nextLong());
            for (int i = 0; i < 9; i++) {
                nums[i] = in.nextInt();
            }
            System.out.println(getString(string, nums));
        }
    }
}
