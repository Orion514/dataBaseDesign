<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2023/1/11
  Time: 3:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page
        import="java.util.List"
        import="com.edu.dao.*"
        import="com.edu.po.*"
        import="com.edu.dao.academic_exchange.*"
        import="com.edu.service.academic.*"
        import="java.text.SimpleDateFormat"
        import="javax.servlet.http.HttpServletRequest"
        import="javax.servlet.http.HttpSession"
%>
<%@ page import="com.edu.dao.base.DaoFactory" %>
<html>
<head>
    <title>成果认定申请</title>
</head>
<body>
    <%
        User user=(User)session.getAttribute("userbean");
        int role_id= DaoFactory.getInstance().getUser_RoleDao().selectRoleIdByUserId(user.getId());
        if(2 == role_id){
    %>
    <form action="paper_confirm.jsp" method="post">
        <input type="submit" value="论文认定">
    </form>
    <form action="prize_confirm.jsp" method="post">
        <input type="submit" value="奖励认定">
    </form>
    <form action="standard_confirm.jsp" method="post">
        <input type="submit" value="标准认定">
    </form>
    <%
        }
        else if(6 == role_id){
    %>
    <form action="paper_confirm.jsp" method="post">
        <input type="submit" value="论文认定">
    </form>
    <form action="textbook_confirm.jsp" method="post">
        <input type="submit" value="教材认定">
    </form>
    <form action="standard_confirm.jsp" method="post">
        <input type="submit" value="标准认定">
    </form>
    <form action="patent_confirm.jsp" method="post">
        <input type="submit" value="专利认定">
    </form>
    <form action="report_confirm.jsp" method="post">
        <input type="submit" value="报告认定">
    </form>
    <form action="platform_confirm.jsp" method="post">
        <input type="submit" value="平台认定">
    </form>
    <%
        }
    %>
</body>
</html>
