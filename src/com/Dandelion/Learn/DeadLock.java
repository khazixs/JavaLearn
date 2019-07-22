package com.Dandelion.Learn;

import java.awt.*;

/*过多的同步可能造成相互不释放资源，从而相互等待，一半发生于同步中持有多个对象锁的时候
* 避免死锁即不要一个对象同时拥有多个锁，不要锁套锁*/
public class DeadLock {
    public static void main(String[] args) {
        Markup g1 = new Markup(1,"大丫");
        Markup g2 = new Markup(0,"二丫");
        g1.start();
        g2.start();
    }
}
//口红
class Lipstick{

}
//镜子
class Mirror{

}
class Markup extends Thread{
    //加静态表示一份，无论创建几个对象
    static Lipstick lipstick = new Lipstick();
    static Mirror mirror = new Mirror();
    //选择
    int choice;
    //name
    String girl;
    public Markup(int choice,String girl){
        this.choice = choice;
        this.girl = girl;
    }
    @Override
    public void run() {
        //化妆
        markup();
    }
    //相互持有对方的对象锁--》才可能造成死锁
    private void markup(){
        if(choice==0){
            synchronized (lipstick){
                System.out.println(this.girl+"获得口红");
                //一秒后想获得镜子
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (mirror){
                    System.out.println(this.girl+"涂口红");
                }
            }
        }else{
            synchronized (mirror){
                System.out.println(this.girl+"获得镜子");
                //2秒后想获得镜子
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lipstick){
                    System.out.println(this.girl+"涂口红");
                }
            }
        }
    }
}