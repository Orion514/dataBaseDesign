<%--
  Created by IntelliJ IDEA.
  User: 2020
  Date: 2023/1/9
  Time: 13:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加项目</title>
</head>
<body>
<form method="post" action="${pageContext.request.contextPath}/AddProject">
    <label>项目编号</label>
    <input type="text"  name="pid"/><br>
    <label>项目名称</label>
    <input type="text"  name="pname"/><br>
    <label>项目类型</label>
    <input type="text"  name="ptype"/><br>
    <label>项目负责人ID(导师ID)</label>
    <input type="text"  name="tutor_id"/><br>
    <label>研究经费</label>
    <input type="text"  name="pfunds"/><br>
    <input type="submit" value="添&nbsp;&nbsp;&nbsp;&nbsp;加"/>
</form>

<a href="admin_index.jsp">返回</a>
</body>
</html>
