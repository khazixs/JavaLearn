package com.Dandelion.Learn;
//1.使用DatagramSocket 指定端口 创建发送端
//2.准备数据 一定要转成字节数组
//3、封装成DatagramPacket包裹，需要指定目的地
//4、发送包裹send(DatagramPacket P)
//5、释放资源

import javax.xml.crypto.Data;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class UdpClient {
    public static void main(String[] args) throws Exception {
        System.out.println("发送端启动中。。。");
        //1.使用DatagramSocket 指定端口 创建发送端
        DatagramSocket client = new DatagramSocket(8888);
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        //2.准备数据 一定要转成字节数组  "盛夏白瓷梅子汤，碎冰碰壁响啷当";
        String  data = console.readLine();
        byte[] datas = data.getBytes();//转字节数组
        //3、封装成DatagramPacket包裹，需要指定目的地
        DatagramPacket packet = new DatagramPacket(datas,0,datas.length,new InetSocketAddress("localhost",9999));
        //4、发送包裹send(DatagramPacket P)
        client.send(packet);
        //5、释放资源
        client.close();
    }
}
