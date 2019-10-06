package com.Dandelion.Designpattern.Observer2;


import java.util.Observer;
import java.util.Observable;

public class ObserverA implements Observer {
    private int myState;

    @Override
    public void update(Observable o, Object arg) {
        myState = ((ConcreteSubject)o).getState();
    }

    public int getMyState() {
        return myState;
    }

    public void setMyState(int myState) {
        this.myState = myState;
    }
}
