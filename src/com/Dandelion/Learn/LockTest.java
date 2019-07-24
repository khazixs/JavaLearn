package com.Dandelion.Learn;
//不可重入锁，锁不可以延续使用
public class LockTest {
    Lock lock = new Lock();
    public void a(){
        lock.lock();
        doSomething();
        lock.unlock();
    }
    public void doSomething(){
        lock.lock();
        lock.unlock();
    }
    public static void main(String[] args) {
        LockTest test = new LockTest();
        test.a();
    }
}

class Lock{
    private boolean isLocked = false;
    public void lock(){
        while(isLocked){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        isLocked = true;
    }

    public synchronized void unlock(){
        isLocked =false;
        notify();
    }
}