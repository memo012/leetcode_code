package com.adminsys.code.单例;

/**
 * @Author: qiang
 * @Description:
 * @Create: 2020-03-28 02-50
 **/
public class Singleton {
    private static Singleton singleton;

    private Singleton() {
    }

    public static Singleton getSingleton() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}