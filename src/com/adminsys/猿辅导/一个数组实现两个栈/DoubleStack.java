package com.adminsys.猿辅导.一个数组实现两个栈;

/**
 * @Author: qiang
 * @Description: 一个数组实现两个栈
 * @Create: 2020-06-02 20-44
 **/

public class DoubleStack {
    private int length;
    private int[] arr;
    private int top1;
    private int top2;

    public DoubleStack(int length) {
        this.length = length;
        arr = new int[length];
        top1 = -1;
        top2 = length;
    }

    public boolean push1(int a) {
        if (top1 + 1 == top2) {
            return false;
        }
        arr[++top1] = a;
        return true;
    }

    public boolean push2(int a) {
        if (top2 - 1 == top1) {
            return false;
        }
        arr[--top2] = a;
        return true;
    }

    public boolean poll1() {
        if (top1 == -1) {
            return false;
        }
        top1--;
        return true;
    }

    public boolean poll2() {
        if (top2 == length) {
            return false;
        }
        top2++;
        return true;
    }

}
