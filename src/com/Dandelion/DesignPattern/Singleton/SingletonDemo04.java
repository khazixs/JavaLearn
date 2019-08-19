package com.Dandelion.Designpattern.Singleton;
//利用静态内部类实现延时加载即用到时候加载，因为外部类非静态所以不会一开始就加载
//线程安全，调用效率高，并且实现了延时加载
public class SingletonDemo04 {
    private static class SingletonClassInstance{
        private static final SingletonDemo04 instance = new SingletonDemo04();
    }
    //构造器依旧需要私有化
    private SingletonDemo04(){

    }
    //方法不需要同步
    public static SingletonDemo04 getInstance(){
        return SingletonClassInstance.instance;
    }
}
