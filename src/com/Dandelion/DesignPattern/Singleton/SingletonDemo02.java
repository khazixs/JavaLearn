package com.Dandelion.Designpattern.Singleton;
//懒汉式，用到时候才加载
public class SingletonDemo02 {
    private static SingletonDemo02 s;

    private SingletonDemo02() {

    }
//判断是否为空，用的时候再加载，必须加同步，否则线程不安全，调用效率低
    public static synchronized SingletonDemo02 getInstance() {
        if (s == null) {
            s = new SingletonDemo02();
        }
        return s;
    }
}
