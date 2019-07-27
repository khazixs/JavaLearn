package com.Dandelion.Chat3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.CopyOnWriteArrayList;

/*ChatRoom Online
 * 实现一个客户可以正常收发信息*/
public class Chat3 {
    private static CopyOnWriteArrayList<Channel> all = new CopyOnWriteArrayList<Channel>();

    public static void main(String[] args) throws IOException {
        System.out.println("----server----");
        //1.指定端口 使用ServerSocket(8888);
        ServerSocket server = new ServerSocket(4396);
        //2.阻塞式等待连接accept()
        while (true) {
            Socket client = server.accept();
            System.out.println("一个客户端建立了连接");
            Channel c = new Channel(client);
            all.add(c);//管理所有的成员
            new Thread(c).start();
        }
    }

    static class Channel implements Runnable {
        private DataInputStream dis;
        private DataOutputStream dos;
        private Socket client;
        private boolean isRunning;
        private String name;

        public Channel(Socket client) {
            this.client = client;
            try {
                dis = new DataInputStream(client.getInputStream());
                dos = new DataOutputStream(client.getOutputStream());
                isRunning = true;
                //获取名称
                this.name = receive();
            } catch (IOException e) {
                e.printStackTrace();
                release();
            }
        }

        //接收消息
        private String receive() {
            String msg = "";
            try {
                msg = dis.readUTF();
            } catch (Exception e) {
                release();
            }
            return msg;
        }

        //发送消息
        private void send(String msg) {
            try {
                dos.writeUTF(msg);
//              System.out.println("chuqule");
                dos.flush();
            } catch (IOException e) {
                System.out.println("---sendError---");
                release();
            }
        }

        //群聊
        private void sendOthers(String msg) {
            for (Channel others : all) {
                if (others == this) {//自己
                    continue;
                } else {
                    others.send(this.name + "对所有人说" + msg);
                }
            }
        }

        //释放资源
        private void release() {
            this.isRunning = false;
            MyUtils3.close(dis, dos, client);
        }

        @Override
        public void run() {
            while (isRunning) {
                String msg = receive();
                if (!msg.equals("")) {
                    sendOthers(msg);
                }
            }
        }
    }
}
