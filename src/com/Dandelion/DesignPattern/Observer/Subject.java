package com.Dandelion.Designpattern.Observer;

import java.util.ArrayList;
import java.util.List;

public class Subject {
    protected List<Observer> list = new ArrayList<>();

    public void registerObserver(Observer obs) {
        list.add(obs);
    }

    public void removeObserver(Observer obs) {

    }

    public void notifyAllObservers() {
        for (Observer obs : list) {
            obs.update(this);
        }
    }
}
