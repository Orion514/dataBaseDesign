<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2023/1/11
  Time: 8:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>平台认证申请</title>
</head>
<body>
<form action="do_platform_confirm" method="post">
  <p>平台名称<input type="text" name="name"></p>
  <p>服务单位<input type="text" name="dept"></p>
  <p>上线时间<input type="text" name="time"></p>
  <p>贡献度<input type="text" name="rank"></p>
  <p><input type="submit" value="提交"></p>
</form>
</body>
</html>
