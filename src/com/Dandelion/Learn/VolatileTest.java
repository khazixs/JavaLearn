package com.Dandelion.Learn;

public class VolatileTest {
    //    private static int num = 0;
    //没加Volatile在CPU繁忙时不会立即更改变量
    private volatile static int num = 0;//加了volatile成功停止

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            while (num == 0) {

            }
        }).start();
        Thread.sleep(1000);
        num = 1;

    }
}
