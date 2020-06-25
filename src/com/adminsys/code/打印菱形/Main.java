package com.adminsys.code.打印菱形;

/**
 * @Author: qiang
 * @Description:
 * @Create: 2020-03-28 13-41
 **/

public class Main {
    public static void print(int n){
        int i, j;
        for (i = 1; i <= n; i++) {
            for (j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            for (j = n - i + 1; j < n + i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        print(3);
    }
}
