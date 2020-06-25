package com.adminsys.多线程.aqs;

public interface Lock {

    /**
     *  尝试获取锁
     */
    public void lock();

    /**
     *  尝试释放锁
     */
    public void unlock();

}
