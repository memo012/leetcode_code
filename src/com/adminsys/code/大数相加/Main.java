package com.adminsys.code.大数相加;

import java.util.Scanner;

/**
 * @Author: qiang
 * @Description:
 * @Create: 2020-04-04 04-45
 **/

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String numa = sc.next();
        String numb = sc.next();
        int alen = numa.length();
        int blen = numb.length();
        int maxlen = 0;
        if (alen > blen) {
            maxlen = alen;
        } else {
            maxlen = blen;
        }
        int[] inta = new int[maxlen];
        int[] intb = new int[maxlen];
        int[] sumArr = new int[maxlen];
        for (int i = maxlen - 1; i >= 0; i--) {
            if (alen <= 0) {
                alen = 0;
                inta[i] = 0;
            } else {
                inta[i] = numa.charAt(--alen) - '0';
            }
            if (blen <= 0) {
                blen = 0;
                intb[i] = 0;
            } else {
                intb[i] = numb.charAt(--blen) - '0';
            }
        }
        int jin = 0;
        for (int i = maxlen - 1; i >= 0; i--) {
            sumArr[i] = (inta[i] + intb[i] + jin) % 10;
            jin = (inta[i] + intb[i] + jin) / 10;
        }
        StringBuilder stringBuilder = new StringBuilder();
        if(jin != 0){
            stringBuilder.append("1");
        }
        for (int i = 0; i < maxlen; i++) {
            stringBuilder.append(sumArr[i]);
        }
        System.out.println(stringBuilder.toString());
    }
}
