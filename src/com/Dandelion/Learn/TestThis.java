package com.Dandelion.Learn;

public class TestThis {
    int a,b,c;
    //构造函数
    TestThis(int a,int b){
        this.a = a;
        this.b = b;
    }
    //构造函数重载
    TestThis(int a,int b,int c){
        this(a,b);//调用之前写的构造方法，必须写在第一句
        this.c = c;
    }

    void sing(){

    }

    void eat(){
        this.sing();
        System.out.println("hahahahh");
    }

    public static void main(String[] args){
        TestThis hi = new TestThis(2,3);
        hi.eat();
    }
}
