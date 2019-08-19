package com.Dandelion.Designpattern.Singleton;

public class Client {
    public static void main(String[] args) {
        SingletonDemo01 s1 = SingletonDemo01.getInstance();
        SingletonDemo01 s2 = SingletonDemo01.getInstance();
        SingletonDemo05 s51 = SingletonDemo05.INSTANCE;
        SingletonDemo05 s52 = SingletonDemo05.INSTANCE;
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s51);
        System.out.println(s52);
    }
}
