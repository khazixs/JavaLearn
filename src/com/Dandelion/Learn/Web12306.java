package com.Dandelion.Learn;

public class Web12306 implements Runnable {
    private int ticketNums = 99;

    @Override
    public void run() {
        while (true) {
            if (ticketNums < 0) {
                break;
            }
            //run方法不能对外抛出异常，所以使用try catch 快捷键是ctrl+win+alt+t
            try {
                Thread.sleep(200);//模拟网络延迟，这时就会出现问题，即有并发问题,结果中就出现了重复和负数
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() +"---->"+ ticketNums--);
        }

    }

    public static void main(String[] args) {
        //一份资源
        Web12306 web = new Web12306();
        //多个代理
        new Thread(web, "小明").start();
        new Thread(web, "小红").start();
        new Thread(web, "小蓝").start();
    }
}
