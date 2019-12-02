<%--
  Created by IntelliJ IDEA.
  User: ZQ
  Date: 2019/10/23
  Time: 11:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
    这个注释为JSP注释
    Jsp中有三种注释：
        1.前端语言注释：会被发送不会被浏览器执行
        2.java语言注释：会被转译，但是不会被servlet执行
        3.Jsp注释：不会被转译
    Jsp的page指令学习
--%>
<html>
<head>
    <title>LearnJsp</title>
</head>
<style>
    #div1 {
        border: solid 1px brown;
        width: 200px;
        height: 100px;
    }
</style>
<body>
<div>
    <input type="button" value="测试" onclick="getData()">
    <div id="div1"></div>
</div>
<div>
    <img src='./Images/1.jpg' width='200px' height='100px'/>
</div>
</body>
<script>
    function getData() {
        //    创建ajax引擎对象
        var ajax;
        if (window.XMLHttpRequest) {//火狐
            ajax = new XMLHttpRequest();
        } else if (window.ActiveXObject) {//ie
            ajax = new ActiveXObject("Msxm12.XMLHTTP");
        }
        //    覆写onreadystatechange
        var oDiv1 = document.getElementById("div1");
        ajax.onreadystatechange = function () {
            if (ajax.readyState === 4) {
                if (ajax.status === 200) {
                    //    获取响应内容
                    // alert(result);
                    //    获取元素对象
                    var result = ajax.responseText
                    oDiv1.innerHTML = result;
                } else if (ajax.status === 404) {
                    oDiv1.innerHTML = "请求资源不存在！";
                } else if (ajax.status === 500) {
                    oDiv1.innerHTML = "服务器繁忙！";
                }
            } else {
                console.log(oDiv1);
                oDiv1.innerHTML = "<img src='./Images/1.jpg' width='200px' height='100px'/>";
            }
        };
        //    发送请求get
        // ajax.open("get", "ajax1?name=张三&pwd=123", true);//默认是true即异步执行
        // ajax.send(null);
        //    发送请求post
        ajax.open("post","ajax");
        ajax.setRequestHeader("Content-type","application/x-www-form-urlencoded");//告诉服务器以键值对形式进行提交
        ajax.send("name=张三&pwd=123")
    }
</script>
</html>
