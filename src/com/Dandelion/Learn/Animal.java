package com.Dandelion.Learn;

abstract public class Animal {
//    抽象方法父类不用实现，子类必须实现，抽象方法必须位于抽象类中，抽象类的意义就在于为子类提供模板方法
    abstract public void shout();
    public void run(){
        System.out.println("跑啊跑啊跑！");
    }

    public static void main(String[] args) {
        Animal a = new Dog();
        a.shout();

    }
}

class Dog extends Animal{
    @Override
    public void shout() {
        System.out.println("汪汪汪！");
    }
}
