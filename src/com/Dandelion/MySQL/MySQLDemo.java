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
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1", "root", "zdk5659");
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        long end = System.currentTimeMillis();
//        System.out.println("建立连接用时：" + (end - start));
//        System.out.println(conn);
//        Statement 接口(用于执行静态不SQL语句并返回他生成结果的对象) 为避免SQL注入，一般不使用Statement接口
//        Statement stmt = conn.createStatement();
//        String sql = "insert into Company (Name,OrderNumber) values ('DD',6789)";
//        stmt.execute(sql);
        String sql1 = "select * from persons where Id>?";
        System.out.println(conn);
        //assert为断言，跟的表达式必须为真
        assert conn != null;
        PreparedStatement ps = conn.prepareStatement(sql1);
        assert ps != null;
        ps.setObject(1, 2);//索引从1开始算
        //单纯执行可以用ps.execute();executeQuery()方法能返回执行数据库语句的结果
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            System.out.println(rs.getInt(1) + "---" + rs.getString(2) + "---" + rs.getString(3) + "---" + rs.getString(4) + "---" + rs.getString(5));
        }
        ps.close();
        conn.close();
//        Statement stmt = conn.createStatement();
//        stmt.execute("insert into persons (Id,LastName,FirstName,Address,City) values (5,'Jone','David','SiChuan Province','ChengDu')");
        System.out.println("插入一条记录");
    }
}