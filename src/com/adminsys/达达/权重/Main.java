package com.adminsys.达达.权重;

/**
 * @author Qiang
 * @version 1.0
 * @description TODO
 * @date 2020/9/5 下午7:59
 **/

import java.util.*;

public class Main {
    public static class Pojo {
        private int id;
        private int weight;
        private int visitCount;

        Pojo(int id, int weight) {
            this.id = id;
            this.weight = weight;
        }

        int getWeight() {
            return this.weight;
        }

        int getId() {
            return this.id;
        }

        int getVisitCount() {
            return this.visitCount;
        }

        void setVisitCount(int visitCount) {
            this.visitCount = visitCount;
        }
    }

    private static List<Pojo> list;
    private static int sum = 0, size = 10, curIndex = 0, gcd = 0, curPojo = 0;
    private static TreeMap<Integer, Integer> map = null;


    public static void getPojo() {
        System.out.println(getMax());
    }

    private static Integer getMax() {
        if (curIndex >= sum) {
            curIndex = 0;
            curPojo = 0;
            for (Pojo p : list) {
                p.setVisitCount(p.getWeight());
            }
        }
        Pojo pojo = list.get(curIndex);
        if (judgeState(pojo)) {
            dealPojo(pojo);
            return pojo.getId();
        }
        while (true) {
            curPojo++;
            if (curPojo >= list.size()) curPojo = 0;
            Pojo pj = list.get(curPojo);
            if (judgeState(pj)) {
                dealPojo(pj);
                return pj.getId();
            }
        }
    }

    private static void dealPojo(Pojo pojo) {
        pojo.setVisitCount(pojo.getVisitCount() - gcd);
        curIndex++;
        curPojo++;
        if (curPojo >= list.size()) curPojo = 0;
    }

    private static boolean judgeState(Pojo pojo) {
        if (pojo == null) return false;
        if (pojo.getVisitCount() > 0) return true;
        return false;
    }


    private static void getTotalWeight() {
        map = new TreeMap<>();
        Pojo pojo;
        for (int i = 0; i < list.size(); i++) {
            pojo = list.get(i);
            sum += pojo.getWeight();
            map.put(sum, pojo.getId());
        }
        sum /= gcd;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num = sc.nextLine();
        list = new ArrayList<>();
        for (int i = 0; i < Integer.parseInt(num); i++) {
            String str = sc.nextLine();
            String[] ch = str.split(",");
            list.add(new Pojo(Integer.parseInt(ch[0]), Integer.parseInt(ch[1])));
        }
        setGcd();
        getTotalWeight();
        for (int i = 0; i < size; i++) getPojo();
    }

    private static void setGcd() {
        int temp = 0;
        for (Pojo p : list) {
            if (temp == 0) {
                temp = p.getWeight();
            } else temp = gd(temp, p.getWeight());
        }
        gcd = temp;
    }

    private static int gd(int temp, int weight) {
        if (temp < weight) return gd(weight, temp);
        int res = temp % weight;
        if (res == 0) return weight;
        return gd(weight, res);
    }
}
