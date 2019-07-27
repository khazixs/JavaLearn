package com.Dandelion.Chat2;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class test {
    public static void main(String[] args) throws IOException {
        System.out.println("----Client----");
        //1.建立连接：使用Socket创建客户端+服务的地址和端口
        Socket client = new Socket("localhost", 8888);
        BufferedReader console=new BufferedReader(new InputStreamReader(System.in));
        DataOutputStream dos= new DataOutputStream(client.getOutputStream());
        dos.writeUTF(console.readLine());
        dos.flush();
    }
}
