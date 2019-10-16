package com.Dandelion.MySQL;

import java.sql.*;

public class MySQLDemo03 {
    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "526995");
            conn.setAutoCommit(false);
            PreparedStatement ps1 = conn.prepareStatement("insert into employees (employee_id,employee_name,department_id,salary) values (?,?,?,?)");
            ps1.setObject(1, 123);
            ps1.setObject(2, "happy");
            ps1.setObject(3, 20113);
            ps1.setObject(4, 123.56);
            ps1.execute();
            System.out.println("插入用户123");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            PreparedStatement ps2 = conn.prepareStatement("insert into employees (employee_id,employee_name,department_id,salary) values (?,?,?,?)");
            ps2.setObject(1, 628);
            ps2.setObject(2, "worry");
            ps2.setObject(3, 20414);
            ps2.setObject(4, 5683);
            ps2.execute();
            System.out.println("插入用户628");

            conn.commit();

            ps1.close();
            ps2.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                assert conn != null;
                conn.rollback();//回滚
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
