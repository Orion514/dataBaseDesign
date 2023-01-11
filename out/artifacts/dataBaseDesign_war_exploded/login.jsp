<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>研究生管理系统登录入口</title>
</head>

<style>
    .title{
        width:100%;
        height:50px;
        font-size:38px;
        color:black;
        text-align:center;
        line-height:50px;
        margin-bottom:20px;
    }
</style>

<body>
<div class="title">欢迎登录研究生管理系统</div>

<form method="post" action="${pageContext.request.contextPath}/GetLogin">
<div style="position:absolute;top:30%;left:40%;margin-left: 0px;margin-top: 0px">
    <label >账号</label>
    <input  type="text" id="account" name="account"/><br>
    <label >密码</label>
    <input  type="password" id="password" name="password"/><br>
    <input style="position:absolute;top:130%;left:40%;margin-left: 0px;margin-top: 0px" type="submit" value="登&nbsp;&nbsp;&nbsp;&nbsp;录"/>
</div>
</form>

</body>
</html>
