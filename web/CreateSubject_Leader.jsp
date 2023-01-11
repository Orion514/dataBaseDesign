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
    <title>创建学科负责人</title>
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

<form method="post" action="${pageContext.request.contextPath}/CreateSubject_LeaderByAdmin">
  <label>用户号</label>
  <input type="text" id="userid" name="userid"/><br>
  <label>学科负责人账号</label>
  <input type="text" id="account" name="account"/><br>
  <label>学科负责人密码</label>
  <input type="password" id="password" name="password"/><br>
  <label>学科负责人号</label>
  <input type="text" id="subject_leader_id" name="subject_leader_id"/><br>
  <label>学科负责人姓名</label>
  <input type="text" id="subject_leader_name" name="subject_leader_name"/><br>
  <label>学科负责人所属学科号</label>
  <input type="text" id="subject_id" name="subject_id"/><br>
  <input type="submit" value="创&nbsp;&nbsp;&nbsp;&nbsp;建"/>
</form>
<br>
<a href="admin_index.jsp">返回</a>
</body>
</html>
