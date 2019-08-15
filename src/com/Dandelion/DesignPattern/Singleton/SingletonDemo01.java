package com.Dandelion.DesignPattern.Singleton;
//饿汉式——》用没用都加载
public class SingletonDemo01 {
    //私有静态属性,类初始化时候立即加载这个对象，加载类时，天然的是线程安全的
    private static SingletonDemo01 instance = new SingletonDemo01();
    //私有化构造器
    private  SingletonDemo01(){

    }
    //提供唯一对外接口返回对象实例，方法没用同步，调用效率高
    public static SingletonDemo01 getInstance(){
        return instance;
    }

}
