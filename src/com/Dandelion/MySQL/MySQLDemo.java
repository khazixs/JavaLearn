package com.Dandelion.MySQL;


import java.sql.*;

public class MySQLDemo {
    public static void main(String[] args) throws SQLException {
//        long start = System.currentTimeMillis();
        //加载驱动类
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //建立连接(连接对象内部其实包含了Socket对象，是一个远程的连接。比较耗时这是Connection对象管理的一个要点)
        //真正开发中，为了提高效率，都会使用连接池
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "526995");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(conn);
//        Statement 接口(用于执行静态不SQL语句并返回他生成结果的对象) 为避免SQL注入，一般不使用Statement接口
//        Statement stmt = conn.createStatement();
//        String sql = "insert into employees value (4,'Nick',10022,5000.21)";
//        stmt.execute(sql);
        String sql1 = "select * from employees";
        System.out.println(conn);
        assert conn != null;
        PreparedStatement ps = conn.prepareStatement(sql1);
        assert ps != null;
        //单纯执行可以用ps.execute();executeQuery()方法能返回执行数据库语句的结果
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            System.out.println(rs.getInt(1) + "---" + rs.getString(2) + "---" + rs.getInt(3) + "---" + rs.getFloat(4));
        }
        ps.close();
        conn.close();
    }
}