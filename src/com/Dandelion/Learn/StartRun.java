package com.Dandelion.Learn;

/*
 * 創建線程的方法二：
 * 1.創建：实现Runnable+重写run（）方法
 * 2.启动：创建实现类对象+Thread对象+start
 * 推荐避免单继承的局限性，优先使用接口，方便共享资源
 * */
public class StartRun implements Runnable {
    /*线程入口*/
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("singing");
        }
    }

    public static void main(String[] args) {
//        启动线程创建实现类对象
//        StartRun sr = new StartRun();
//        创建代理类对象
//        Thread t = new Thread(sr);
//        启动
//        t.start();
//        简化一下，用匿名类
        new Thread(new StartRun()).start();//三步一体

        for (int i = 0; i < 200; i++) {
            System.out.println("coding");
        }
    }
}
