package com.Dandelion.Learn;

public class TestInnerClass {
    public static void main(String[] args) {
        Outer.Inner inner = new Outer().new Inner();
        inner.show();
    }
}

class Outer {
    private int age = 100;
//内部类能形成一个良好的封装环境
    class Inner {
        int age = 60;

        public void show() {
            int age = 20;
            System.out.println("外部类成员变量" + Outer.this.age);
            System.out.println("内部类成员变量" + this.age);
            System.out.println("局部成员变量" + age);
        }
    }
}