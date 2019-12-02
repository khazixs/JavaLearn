package com.Dandelion.Designpattern.Lisenter;/*
 * @program: JavaLearn
 * @author: IceCoLa
 */

public class DemoListener1 implements DemoListener {
    @Override
    public void handleEvent(DemoEvent de) {
        System.out.println("Inside listener1 ...");
        de.say();//回调
    }
}
