package com.Dandelion.Learn;

/*Lambda表达式 简化线程（用一次）使用*/
public class LambdaThread {

    public static void main(String[] args) {
        //匿名内部类必须借助接口或者父类
//        new Thread(new Runnable(){
//            public void run() {
//                for (int i = 0; i < 20; i++) {
//                    System.out.println("singing");
//                }
//            }
//        }).start();
//        Lamda表达式简化：将new Runnable(){public void run(){}}进行简化，只适用于一个单
        new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                System.out.println("singing");
            }
        }
        ).start();
    }
}
