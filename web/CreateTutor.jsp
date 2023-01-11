<%--
  Created by IntelliJ IDEA.
  User: 2020
  Date: 2023/1/10
  Time: 21:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>创建导师</title>
</head>
<body>
<p>学科如下：</p>
<table border="1">
  <thead>
  <tr>
    <td>学科ID</td>
    <td>学科名</td>
  </tr>
  </thead>
  <tbody>
  <tr>
    <td>S0000001</td>
    <td>计算机</td>
  </tr>
  <tr>
    <td>S0000002</td>
    <td>林学</td>
  </tr>
  <tr>
    <td>S0000003</td>
    <td>工学</td>
  </tr>
  </tbody>
</table>

<form method="post" action="${pageContext.request.contextPath}/CreateTutorByAdmin">
  <label>用户号</label>
  <input type="text" id="userid" name="userid"/><br>
  <label>导师账号</label>
  <input type="text" id="account" name="account"/><br>
  <label>导师密码</label>
  <input type="password" id="password" name="password"/><br>
  <label>导师号</label>
  <input type="text" id="tutor_id" name="tutor_id"/><br>
  <label>导师名</label>
  <input type="text" id="tutor_name" name="tutor_name"/><br>
  <label>导师所属学科号</label>
  <input type="text" id="sub_id" name="sub_id"/><br>
  <input type="submit" value="创&nbsp;&nbsp;&nbsp;&nbsp;建"/>
</form>
<br>
<a href="admin_index.jsp">返回</a>
</body>
</html>
