package com.Dandelion.Learn;
import java.util.concurrent.atomic.AtomicInteger;
/*CAS比较并交换*/
public class CAS {
    private static AtomicInteger stock = new AtomicInteger(5);

    public static void main(String[] args) {
        for (int i=0;i<5;i++){
            new Thread(()->{
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Integer left = stock.decrementAndGet();//以原子的方式将此更新管理器中的给定对象当前值减1
                System.out.println("left是"+left);
                if (left<1){
                    System.out.println(Thread.currentThread().getName()+"没抢到");
                    return;
                }
                System.out.println(Thread.currentThread().getName()+"抢了一件商品"+"--》还剩下"+left);
            }).start();
        }
    }
}

