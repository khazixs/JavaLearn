<%@ page import="java.security.PublicKey" %><%--
  Created by IntelliJ IDEA.
  User: ZQ
  Date: 2019/10/17
  Time: 14:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="loginService" method="post">
        用户名：<input type="text" name="userName" value=""/><br />
        密码：<input type="text" name="pwd" value=""/><br />
        <input type="submit" value="登录" />
    </form>
</body>
<%
    String str = (String) request.getAttribute("str");
    if(str!=null){
        response.getWriter().write(str);
    }
%>
</html>
