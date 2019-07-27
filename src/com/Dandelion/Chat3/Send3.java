package com.Dandelion.Chat3;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Send3 implements Runnable {
    private BufferedReader console;
    private DataOutputStream dos;
    private Socket client;
    private boolean isRunning;
    private String name;

    public Send3(Socket client, String name) {
        this.client = client;
        this.name = name;
        console = new BufferedReader(new InputStreamReader(System.in));
        try {
            dos = new DataOutputStream(client.getOutputStream());
            //发送名称
            send(name);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("===客户端send（）出错===");
            this.release();
        }
    }

    //释放资源
    private void release() {
        this.isRunning = false;
        MyUtils3.close(dos, client);
    }

    //从控制台获取消息
    private String getStrFromConsole() {
        try {
            return console.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    private void send(String msg) {
        //System.out.println("进来了");
        try {
            dos.writeUTF(msg);
//            System.out.println("dos.writeUTF(msg)成功");
            dos.flush();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("===客户端发送失败===");
            release();
        }

    }

    @Override
    public void run() {
        isRunning = true;
        while (isRunning) {
            String msg = getStrFromConsole();
//            System.out.println(msg);
            if (!msg.equals("")) {
//                System.out.println("还差一步");
                send(msg);
            }
        }
    }
}
