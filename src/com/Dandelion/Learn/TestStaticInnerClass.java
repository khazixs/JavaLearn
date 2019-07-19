package com.Dandelion.Learn;

public class TestStaticInnerClass {
    public static void main(String[] args) {
        Outer2.Inner2 inner2 = new Outer2.Inner2();//静态内部类不依托外部成员
    }
}
class Outer2{

    static class Inner2{

    }
}