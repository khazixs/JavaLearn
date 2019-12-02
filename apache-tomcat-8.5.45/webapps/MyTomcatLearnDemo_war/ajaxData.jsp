<%--
  Created by IntelliJ IDEA.
  User: ZQ
  Date: 2019/10/24
  Time: 14:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>欢迎访问英雄商店</title>
    <%--    需求分析：
                1.当前页面内显示查询结果，使用ajax
                2.创建ajax函数
                3.调用ajax函数发送请求到UserServlet
                4.调用业务层获取对应的数据

    --%>
</head>
<body>
<h3>欢迎访问英雄商店</h3>
<hr>
英雄名称：<input type="text" name="name" value="" id="theName">
<input type="button" value="搜索" onclick="getData()">
<hr>
<table border="1px" id="mt">
    <tr>
        <td>编号</td>
        <td>名称</td>
        <td>价格</td>
        <td>位置</td>
        <td>描述</td>
    </tr>
</table>
</body>
<script>
    function getData() {
        //    创建ajax对象
        var ajax;
        if (window.XMLHttpRequest) {//火狐
            ajax = new XMLHttpRequest();
        } else if (window.ActiveXObject) {//ie
            ajax = new ActiveXObject("Msxm12.XMLHTTP");
        }
        ajax.onreadystatechange = function () {
            if (ajax.readyState === 4) {
                if (ajax.status === 200) {
                    // var id = ajax.getResponseHeader("id");
                    // var heroName = ajax.getResponseHeader("name");
                    // var price = ajax.getResponseHeader("price");
                    // var location = ajax.getResponseHeader("location");
                    // var description = ajax.getResponseHeader("description");
                    var tds = document.getElementById("mt").rows[0].cells;
                    var result = ajax.responseText;
                    var u1;
                    eval("u1 =" + result);
                    tds[0].innerHTML = u1.id;
                    tds[1].innerHTML = u1.name;
                    tds[2].innerHTML = u1.price;
                    tds[3].innerHTML = u1.location;
                    tds[4].innerHTML = u1.description;
                    console.log(u1.name)


                }
            }
        };
        ajax.open("get", "ajax2?name=" + document.getElementById("theName").value, true);
        ajax.send(null);

    }
</script>
</html>
