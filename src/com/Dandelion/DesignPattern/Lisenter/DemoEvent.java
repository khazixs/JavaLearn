package com.Dandelion.Designpattern.Lisenter;/*
 * @program: JavaLearn
 * @author: IceCoLa
 */

public class DemoEvent extends java.util.EventObject {
    public DemoEvent(Object source){
        super(source);
    }
    public void say(){
        System.out.println("This is say method...");
    }

}
