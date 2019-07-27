package com.Dandelion.Chat3;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class Receive3 implements Runnable {
    private Socket client;
    private DataInputStream dis;
    private boolean isRunning;

    public Receive3(Socket client) {
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
        //System.out.println("第3步成功");
        String msg = "";
        try {
            msg = dis.readUTF();
            //System.out.println("第4步成功");
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
        MyUtils3.close(dis, client);
    }
    @Override
    public void run() {
        isRunning = true;
        //System.out.println("第一步成功");
        while (isRunning){
            //System.out.println("第二步成功");
            String msg = receive();
            //System.out.println("第5步成功");
            if(!msg.equals("")){
                //System.out.println("第6步成功");
                System.out.println(msg);
            }
        }
    }
}
