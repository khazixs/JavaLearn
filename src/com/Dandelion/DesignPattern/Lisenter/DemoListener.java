package com.Dandelion.Designpattern.Lisenter;/*
 * @program: JavaLearn
 * @author: IceCoLa
 */

import com.Dandelion.Designpattern.Lisenter.DemoEvent;

import java.util.EventListener;

public interface DemoListener extends EventListener {
    public void handleEvent(DemoEvent dm);
}
