package com.adminsys.猿辅导.去除捣乱的报数;

import java.util.*;
public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int k = sc.nextInt();
            if (list.contains(k)) continue;
            map.put(k, map.getOrDefault(k, 0) + 1);
            if (map.get(k) > m){
                map.remove(k);
                list.add(k);
            }
        }
        
        for (Integer in : map.keySet()) {
            int value = map.get(in);
            for (int i = 0; i < value; i++)
                System.out.print(in + " ");
        }
    }
}