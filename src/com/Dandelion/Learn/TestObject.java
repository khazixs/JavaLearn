package com.Dandelion.Learn;

import java.util.HashMap;

public class TestObject {
    public static void main(String[] args) {
        TestObject to = new TestObject();
        System.out.println(to);
        System.out.println(to.toString());//即默认调用Object的toString()方法输出
    }
    //重写toString()方法
    public String toString(){
        return getClass().getName() + "@" + Integer.toBinaryString(hashCode());
    }
}
