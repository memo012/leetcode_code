package com.adminsys.美团.one;


import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        Arrays.sort(arr);
        int j = n - 1, i = 0, pg, suma = 0, sumb = 0;
        while (i < j) {
            pg = arr[j] - arr[i];
            if (pg > m){
                j--;
                suma++;
            }else {
                break;
            }
        }
        i = 0;
        j = n - 1;
        while (i < j) {
            pg = arr[j] - arr[i];
            if (pg > m){
                i++;
                sumb++;
            }else {
                break;
            }
        }
        if(i == j){
            System.out.println(n-1);
        }else{
            System.out.println(suma > sumb ? sumb : suma);
        }
    }
}
