package com.Dandelion.Learn;

/*
 * 創建線程的方法：
 * 1.創建：继承Thread+重写run（）方法
 * 2.启动：创建子类对象+start
 * */
public class StartThread extends Thread {
    /*线程入口*/
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("singing");
        }
    }

    public static void main(String[] args) {
//        启动线程
        StartThread st = new StartThread();
        st.start();
        for (int i = 0; i < 200; i++) {
            System.out.println("coding");
        }
    }
}
