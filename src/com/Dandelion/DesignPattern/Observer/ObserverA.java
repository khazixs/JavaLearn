package com.Dandelion.Designpattern.Observer;


public class ObserverA implements Observer {
    private int myState;//需要跟目标对象的state值保持一样

    @Override
    public void update(Subject subject) {
        myState = ((ConcreteSubject) subject).getState();
    }

    public int getMyState() {
        return myState;
    }

    public void setMyState(int myState) {
        this.myState = myState;
    }
}
