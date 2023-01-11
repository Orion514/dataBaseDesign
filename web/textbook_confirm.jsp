<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2023/1/11
  Time: 8:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>教材认证申请</title>
</head>
<body>
<form action="do_textbook_confirm" method="post">
  <p>教材名称<input type="text" name="name"></p>
  <p>出版社<input type="text" name="press"></p>
  <p>出版时间<input type="text" name="time"></p>
  <p>贡献度<input type="text" name="point"></p>
  <p><input type="submit" value="提交"></p>
</form>
</body>
</html>
