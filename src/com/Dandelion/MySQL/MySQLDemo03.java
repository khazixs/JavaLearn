package com.Dandelion.MySQL;

import java.sql.*;

public class MySQLDemo03 {
    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1", "root", "zdk5659");
            conn.setAutoCommit(false);
            PreparedStatement ps1 = conn.prepareStatement("insert into test (id,username) values (?,?)");
            ps1.setObject(1, "list3.14");
            ps1.setObject(2, "happy");
            ps1.execute();
            System.out.println("插入用户3.14");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            PreparedStatement ps2 = conn.prepareStatement("insert into test (id,username) values (?,?,?)");
            ps2.setObject(1, "list6.28");
            ps2.setObject(2, "worry");
            ps2.execute();
            System.out.println("插入用户6.28");

            conn.commit();

            ps1.close();
            ps2.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                conn.rollback();//回滚
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
