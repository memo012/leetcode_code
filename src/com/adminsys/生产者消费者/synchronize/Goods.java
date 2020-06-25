package com.adminsys.生产者消费者.synchronize;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: qiang
 * @Description:
 * @Create: 2020-03-30 14-48
 **/

public class Goods {
    private String goodsName;
    private Integer count = 0;
    private Integer full;

    private Lock lock = new ReentrantLock();
    private Condition producerCondition = lock.newCondition();
    private Condition customerCondition = lock.newCondition();

    public Goods(Integer full){
        this.full = full;
    }

    public void setGoods(String goodsName){
        try {
            lock.lock();
            while (this.count == this.full){
                try {
                    producerCondition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.goodsName = goodsName;
            this.count++;
            customerCondition.signalAll();
        }finally {
            lock.unlock();
        }
    }

    public void get(){
        try {
            lock.lock();
            while (this.count == 0){
                try {
                    customerCondition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.count--;
            // 生产者
            producerCondition.signalAll();
        }finally {
            lock.unlock();
        }
    }
}