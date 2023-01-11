<%@ page import="com.edu.domain.common.Tutor" %>
<%@ page import="java.util.List" %>
<%@ page import="com.edu.dao.base.DaoFactory" %><%--
  Created by IntelliJ IDEA.
  User: 2020
  Date: 2023/1/10
  Time: 21:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>创建研究生</title>
</head>
<body>
<p>导师如下：</p>
<table border="1">
    <thead>
    <tr>
        <td>导师号</td>
        <td>导师名</td>
    </tr>
    </thead>

    <%
        List<Tutor> tutors= DaoFactory.getInstance().getTutorDao().selectAllTutor();
        for(Tutor tutor:tutors){
    %>
    <tbody>
    <tr>
        <td><%=tutor.getId()%></td>
        <td><%=tutor.getName()%></td>
    </tr>
    </tbody>
    <%
        }
    %>

</table>

<form method="post" action="${pageContext.request.contextPath}/CreatePostgraduateByAdmin">
    <label>用户号</label>
    <input type="text" id="userid" name="userid"/><br>
    <label>研究生账号</label>
    <input type="text" id="account" name="account"/><br>
    <label>研究生密码</label>
    <input type="password" id="password" name="password"/><br>
    <label>研究生号</label>
    <input type="text" id="pg_id" name="pg_id"/><br>
    <label>研究生姓名</label>
    <input type="text" id="pg_name" name="pg_name"/><br>
    <label>研究生类型</label>
    <input type="text" id="pg_type" name="pg_type"/><br>
    <label>所属导师号</label>
    <input type="text" id="tutor_id" name="tutor_id"/><br>
    <input type="submit" value="创&nbsp;&nbsp;&nbsp;&nbsp;建"/>
</form>
<br>
<a href="admin_index.jsp">返回</a>

</body>
</html>
