package com.Dandelion.Designpattern.Singleton;

import java.util.concurrent.CountDownLatch;

public class Client3 {
    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();
        int theadNum = 10;
        final CountDownLatch countDownLatch = new CountDownLatch(theadNum);
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 10000000; i++) {
                        Object o = SingletonDemo04.getInstance();
//                        Object o = SingletonDemo05.INSTANCE;
                    }
                    countDownLatch.countDown();
                }
            }).start();
        }
        countDownLatch.await();//main线程阻塞，直到计数器变为零，才向下继续执行
        long end = System.currentTimeMillis();
        System.out.println("总耗时：" + (end - start));
    }
}
