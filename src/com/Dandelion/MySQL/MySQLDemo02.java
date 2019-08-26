package com.Dandelion.MySQL;


import java.sql.*;

public class MySQLDemo02 {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1", "root", "zdk5659");
        conn.setAutoCommit(false);//设置为手动提交
        Statement stmt = conn.createStatement();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 2000; i++) {
            stmt.addBatch("insert into test (id,username) values ('list"+i+"','happy') ");//批处理一般不使用PreparedStatement因为会占用大量预编译空间
        }
        stmt.executeBatch();
        conn.commit();//提交事务
        long end = System.currentTimeMillis();
        System.out.println("该次批处理用时：" + (end - start));

    }
}