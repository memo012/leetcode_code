package com.adminsys.多线程.blockingqueue;

public interface Queue {

    /**
     *  入队
     * @param element
     */
    public void put(Object element);

    /**
     *  出队
     * @return
     */
    public Object take();

}
