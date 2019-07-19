package com.Dandelion.Learn;
//接口能更好的实现规范和具体的分离
//接口里面只能定义常量和抽象方法
interface Volant{
    /*public static final*/int FLY_HEIGHT = 10000;
    /*public abstract*/void fly();
}

public class MyInterface{
    public static void main(String[] args) {
        Angel a = new Angel();
        a.fly();
        a.helpOther();

    }
}

interface Honest{
    void helpOther();
}
//实现多个接口
class Angel implements Volant,Honest{
    @Override
    public void helpOther(){
        System.out.println("Angel.helpOther()");
    }

    @Override
    public void fly() {
        System.out.println("Angel.fly()");
    }
}

class BirdMan implements Honest{
    @Override
    public void helpOther() {
        System.out.println("BirdMan.helpOther()");
    }
}