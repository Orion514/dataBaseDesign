<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2023/1/11
  Time: 7:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>标准认定申请</title>
</head>
<body>
<form action="do_standard_confirm" method="post">
  <p>标准名称<input type="text" name="std_name"></p>
  <p>标准等级
    <select name="type">
      <option>国家标准</option>
      <option>省部级地方标准</option>
      <option>行业标准</option>
      <option>团队标准</option>
    </select>
  </p>
  <p>发布时间<input type="text" name="time"></p>
  <p><input type="submit" value="提交"></p>
</form>
</body>
</html>
