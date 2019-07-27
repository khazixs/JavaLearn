package com.Dandelion.Chat2;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class Receive implements Runnable {
    private Socket client;
    private DataInputStream dis;
    private boolean isRunning;

    public Receive(Socket client) {
        this.client = client;
        try {
            dis = new DataInputStream(client.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("===客户端获取创建失败===");
            release();
        }
    }
    //接收消息
    private String receive(){
        String msg = "";
        try {
            msg = dis.readUTF();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("===客户端收取消息失败===");
            release();
        }
        return msg;
    }
    //释放资源
    private void release() {
        this.isRunning = false;
        MyUtils.close(dis, client);
    }
    @Override
    public void run() {
        while (isRunning){
            String msg = receive();
            if(msg.equals("")){
                System.out.println(msg);
            }
        }
    }
}
