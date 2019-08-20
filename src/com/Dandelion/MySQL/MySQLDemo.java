package com.Dandelion.MySQL;


import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLDemo {
    public static void main(String[] args) throws Exception {
        //加载驱动类
        Class.forName("com.mysql.jdbc.Driver");
        //建立连接(连接对象内部其实包含了Socket对象，是一个远程的连接。比较耗时这是Connection对象管理的一个要点)
        //真正开发中，为了提高效率，都会使用连接池

        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1", "root", "zdk5659");
        System.out.println(conn);
    }
}