package com.adminsys.code;


import java.util.Arrays;
import java.util.Comparator;

class MyComparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        return (int) o2 - (int) o1;
    }
}

public class Main {
    public static void main(String[] args) {
        Integer[] arr = {1, 5, 3, 2, 8};
        Arrays.sort(arr, new MyComparator());
        System.out.println(arr[0]);
    }
}