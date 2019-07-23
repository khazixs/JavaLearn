package com.Dandelion.Learn;

public class CoTest01 {
    public static void main(String[] args) {
        SynContainer container = new SynContainer();
        new Productor(container).start();
        new Consumer(container).start();
    }
}

//生产者
class Productor extends Thread {
    SynContainer container;

    public Productor(SynContainer container) {
        this.container = container;
    }

    @Override
    public void run() {
        //生产
        for (int i = 0
             ; i < 20; i++) {
            System.out.println("生产--》第" + i + "馒头");
            Steamedbun bun = new Steamedbun(i);
            container.push(bun);
        }
    }
}

//消费者
class Consumer extends Thread {
    SynContainer container;

    public Consumer(SynContainer container) {
        this.container = container;
    }

    @Override
    public void run() {
        //消费
        for (int i = 0; i < 20; i++) {
            System.out.println("消费--》第" + container.pop().id + "馒头");
        }

    }
}

//缓冲区
class SynContainer {
    Steamedbun[] buns = new Steamedbun[10];
    int count = 0;//counter

    //store
    public synchronized void push(Steamedbun bun) {
        if (count == buns.length) {
            try {
                this.wait();//线程阻塞 消费者通知生产才结束阻塞
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        buns[count] = bun;
        count++;
        this.notifyAll();//唤醒等待的线程
    }

    //get
    public synchronized Steamedbun pop() {
        //何时消费 容器中是否存在数据
        if (count == 0) {
            try {
                this.wait();//线程阻塞 生产这通知消费才结束阻塞
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //存在数据可以消费
        count--;
        Steamedbun bun = buns[count];
        this.notifyAll();//唤醒等待的线程
        return bun;
    }
}

//馒头
class Steamedbun {
    int id;

    public Steamedbun(int id) {
        this.id = id;
    }
}