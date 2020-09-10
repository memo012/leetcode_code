package com.adminsys.负载均衡.权重;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: qiang
 * @Description: 轮询机制
 * @Create: 2020-04-05 13-06
 **/
class TrainPojo {
    private String name;
    private Integer weight;

    public TrainPojo(String name, Integer weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }
}

public class TrainMessage {
    private static AtomicInteger atomicInteger = new AtomicInteger();
    private List<TrainPojo> list;
    // 总权重
    private int sum = 0;
    private static TreeMap<Integer,String> map = null;
    {
        list = new ArrayList<>();
        list.add(new TrainPojo("8080", 1));
        list.add(new TrainPojo("8081", 3));
        list.add(new TrainPojo("8082", 6));
        getTotalWeight();
    }

    /**
     *  获取权重要服务的机器
     */
    public void getTrainMessage() {
        System.out.println(getMax());
    }

    /**
     *  获得给定List集合里权重大的结果
     */
    private String getMax() {
        int random = (int)(Math.random() * sum);
        return map.get(map.ceilingKey(random));
    }

    /**
     * 获取服务器总权重数
     */
    private void getTotalWeight() {
        map = new TreeMap<>();
        TrainPojo weightPojo;
        for (int i = 0; i < list.size(); i++) {
            weightPojo = list.get(i);
            sum += weightPojo.getWeight();
            map.put(sum, weightPojo.getName());
        }
    }

    public static void main(String[] args) {
        TrainMessage trainMessage = new TrainMessage();
        for (int i = 0; i < 100; i++) {
            trainMessage.getTrainMessage();
        }
    }

}
