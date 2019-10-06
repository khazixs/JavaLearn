package com.Dandelion.Designpattern.Observer;

public class Client {
    public static void main(String[] args) {
        //object
        ConcreteSubject subject = new ConcreteSubject();
        //observers
        ObserverA obs1 = new ObserverA();
        ObserverA obs2 = new ObserverA();
        ObserverA obs3 = new ObserverA();
        //let them go in list
        subject.registerObserver(obs1);
        subject.registerObserver(obs2);
        subject.registerObserver(obs3);
        //change the state of subject
        subject.setState(3000);
        System.out.println("###############################");
        System.out.println(obs1.getMyState());
        System.out.println(obs2.getMyState());
        System.out.println(obs3.getMyState());
        //change the state of subject
        subject.setState(110);
        System.out.println("###############################");
        System.out.println(obs1.getMyState());
        System.out.println(obs2.getMyState());
        System.out.println(obs3.getMyState());
    }
}
