package com.Dandelion.Learn;

public class Racer implements Runnable {
    private static String winner;

    @Override
    public void run() {
        for (int step = 1; step <= 100; step++) {
            //模拟休息
            if (Thread.currentThread().getName().equals("rabbit") && step % 10 == 0) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + "--->" + step);
            boolean flag = gameOver(step);
            if (flag) {
                break;
            }
        }
    }

    private boolean gameOver(int step) {
        if (winner != null) {
            return true;
        } else {
            if (step == 100) {
                winner = Thread.currentThread().getName();
                System.out.println("winner is " + winner);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Racer racer = new Racer();
        new Thread(racer, "rabbit").start();
        new Thread(racer, "tortoise").start();

    }
}