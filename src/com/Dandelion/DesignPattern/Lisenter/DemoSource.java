package com.Dandelion.Designpattern.Lisenter;/*
 * @program: JavaLearn
 * @author: IceCoLa
 */

import com.Dandelion.Designpattern.Lisenter.DemoEvent;
import com.Dandelion.Designpattern.Lisenter.DemoListener;

import java.util.Enumeration;
import java.util.Vector;

public class DemoSource {
    private Vector<DemoListener> repository = new Vector<DemoListener>();//监听自己的监听器队列
    public DemoSource(){}
    public void addDemoListener(DemoListener dl){
        repository.addElement(dl);
    }
    public void notifyDemoEvent(){//通知所有的监听器
        Enumeration enumeration = repository.elements();
        while (enumeration.hasMoreElements()){
            DemoListener dl = (DemoListener)enumeration.nextElement();
            dl.handleEvent(new DemoEvent(this));
        }
    }

}
