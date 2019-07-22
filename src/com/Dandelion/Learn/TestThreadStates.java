package com.Dandelion.Learn;

import java.lang.Thread.State;

public class TestThreadStates {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("....");

        });
        State state = t.getState();
        System.out.println("first--->" + state);//NEW
        t.start();
        state = t.getState();
        System.out.println("second--->" + state);//RUNNABLE
//        while(state != State.TERMINATED){
//            try {
//                Thread.sleep(200);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            state = t.getState();//TIMED_WAITING阻塞状态  TERMINATED结束状态
//            System.out.println("next--->"+state);
//        }
        while (true) {
            int num = Thread.activeCount();
            System.out.println("现在活动的线程数"+num);
            if(num == 1){
                break;
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            state = t.getState();//TIMED_WAITING阻塞状态  TERMINATED结束状态
            System.out.println("next--->" + state);
        }
    }
}
