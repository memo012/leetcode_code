package com.adminsys.多线程.中奖;

import java.util.List;

/**
 * @Author: qiang
 * @Description:
 * @Create: 2020-04-03 04-11
 **/
public class Main {
    public static Prize lotteryAlgorithm(List<Prize> prizes) {
        double sum = prizes.stream().mapToDouble(Prize::getProbability).sum();
        double d = Math.random() * (sum > 100 ? sum : 100);
        return null;
    }
    public static void main(String[] args) {
    }
}
