package com.Dandelion.Designpattern.Observer2;

import java.util.Observable;

public class ConcreteSubject extends Observable {
    private int state;

    public void set(int s){
        state = s;
        setChanged();//表示目标对象已经发生了变化
        notifyObservers(state);//表示通知所有观察者
    }

    public int getState() {
        return state;
    }
}
