package com.Dandelion.Learn;

import com.sun.tools.javac.Main;

public class StaticProxy {
    public static void main(String[] args) {
        new WeddingCompany(new You()).happyMarry();
        //new Thread（线程对象）.start();关注点应该在you这个目标
        //静态代理，做日志
    }
}
interface Marry{
    void happyMarry();
}
//真实角色
class You implements Marry{

    @Override
    public void happyMarry() {
        System.out.println("you and your baby are happy ");
    }
}
//代理
class WeddingCompany implements Marry{
    private Marry tatget;
    public WeddingCompany(Marry target){
        this.tatget = target;
    }

    @Override
    public void happyMarry() {
        ready();
        this.tatget.happyMarry();
        after();
    }

    private void ready(){
        System.out.println("布置房间");
    }
    private void after(){
        System.out.println("happyness");
    }
}
