package com.Dandelion.Chat2;

import java.io.*;
import java.net.Socket;
import com.Dandelion.Chat2.Send;

public class MultiClient2 {
    public static void main(String[] args) throws IOException {
        System.out.println("----Client----");
        //1.建立连接：使用Socket创建客户端+服务的地址和端口
        Socket client = new Socket("localhost", 9999);

        //2.客户端发送消息
        new Thread(new Send(client)).start();
        //3.客户端获取消息
        new Thread(new Receive(client)).start();

    }
}
