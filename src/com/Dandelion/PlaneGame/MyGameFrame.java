package com.Dandelion.PlaneGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/*
* 飞机游戏主窗口
* */
public class MyGameFrame extends JFrame {
    /*初始化窗口*/
    public void launchFrame(){
        this.setTitle("飞机游戏");
        this.setVisible(true);
        this.setSize(500,500);
        this.setLocation(200,200);
        this.addWindowListener(new WindowAdapter() {
            @Override
//            关闭窗口，同时关闭程序执行
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
//    public void paint(Graphics g){
//        g.drawLine(100,100,200,200);
//    }
    public static void main(String[] args) {
        MyGameFrame f = new MyGameFrame();
        f.launchFrame();
    }
}
