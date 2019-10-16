package com.Dandelion.MySQL;


import java.sql.*;

public class MySQLDemo02 {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "526995");
        conn.setAutoCommit(false);//设置为手动提交
        Statement stmt = conn.createStatement();
        long start = System.currentTimeMillis();
        for (int i = 5; i < 20; i++) {
            stmt.addBatch("insert into employees (employee_id,employee_name,department_id,salary) value (" + i + ",\'" + randString(5) + "\',10002,100) ");//批处理一般不使用PreparedStatement因为会占用大量预编译空间
            System.out.println("insert into employees (employee_id,employee_name,department_id,salary) value (" + i + "," + randString(5) + ",10002,100) ");
        }
        stmt.executeBatch();
        conn.commit();//提交事务
        long end = System.currentTimeMillis();
        System.out.println("该次批处理用时：" + (end - start));

    }

    public static String randString(int number) {
        StringBuilder sb1 = new StringBuilder();
        while (number > 0) {
            sb1.append(String.valueOf((char) (Math.random() * 25 + 65)));
            number--;
        }
//        System.out.println(sb1.toString());
        return sb1.toString();
    }
}