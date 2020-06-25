package com.adminsys.link;

/**
 * @Author: qiang
 * @Description:
 * @Create: 2020-03-28 13-59
 **/

public class CompareAndSwap {
    /**
     * 内存值
     */
    private volatile int value = 0;

    /**
     * 返回内存值
     *
     * @return
     */
    public synchronized int getValue() {
        return value;
    }

    /**
     * 如果预期值与内存值相等时 则修改内存为新的值
     *
     * @param expectedValue 预期值
     * @param newValue      新值
     * @return
     */
    public synchronized int compareAndSwap(int expectedValue, int newValue) {
        int oldValue = getValue();
        if (expectedValue == oldValue) {
            value = newValue;
        }
        return oldValue;
    }

    /**
     * 如果更新成功，新的内存值和预期值相等
     *
     * @param expectedValue 预期值
     * @param newValue      新值
     * @return
     */
    public synchronized boolean compareAndSet(int expectedValue, int newValue) {
        return expectedValue == compareAndSwap(expectedValue, newValue);
    }
}