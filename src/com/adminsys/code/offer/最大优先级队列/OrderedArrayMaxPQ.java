package com.adminsys.code.offer.最大优先级队列;

/**
 * @author Qiang
 * @version 1.0
 * @description 优先队列实现
 * @date 2020/7/1 下午9:49
 **/
public class OrderedArrayMaxPQ {

    private int capacity;
    private int[] array;
    private int index;

    public OrderedArrayMaxPQ(int capacity) {
        this.capacity = capacity;
        array = new int[capacity];
        index = 0;
    }
    public void add(int param) {
        if (index == 0) {
            array[index++] = param;
            return;
        }
        int j = 0;
        for (j = index - 1; j >= 0; j--) {
            if (param < array[j]) array[j+1] = array[j];
            else break;
        }
        array[j+1] = param;
        index++;
    }
    public int pop() {
        return array[--index];
    }

    public static void main(String[] args) {
        OrderedArrayMaxPQ o  = new OrderedArrayMaxPQ(5);
        o.add(1);
        o.add(8);
        o.add(4);
        o.add(32);
        o.add(0);
        System.out.println(o.pop());
        System.out.println(o.pop());
    }
}
