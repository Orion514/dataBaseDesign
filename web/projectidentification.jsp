<%@ page import="com.edu.dao.base.DaoFactory" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="com.edu.po.*" %>
<%@ page import="com.edu.domain.project.Participate" %>
<%@ page import="com.edu.domain.project.Project" %><%--
  Created by IntelliJ IDEA.
  User: 2020
  Date: 2023/1/9
  Time: 16:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>项目认定情况</title>
</head>
<body>
<%String result="";%>
<%
    User user=(User)session.getAttribute("userbean");
    int user_id=user.getId();
    Postgraduate postgraduate=DaoFactory.getInstance().getPostgraduateDao().selectPostgraduateByUserId(user_id);
    Participate participate=DaoFactory.getInstance().getParticipateDao().getParticipateByPostgraduateId(postgraduate.getId());
    if(participate==null){
        result="未完成项目认定";
    }
    else if(participate.getFunds()<=0.0001){
        result="未完成项目认定";
    }
    else{
        result="已完成项目认定";
    }
%>

    <p><%=result%></p><br>
<%
    if(result.equals("已完成项目认定")){
        Project project=DaoFactory.getInstance().getProjectDao().selectProjectByIdentifier(participate.getProject_id());
        Tutor tutor=DaoFactory.getInstance().getTutorDao().selectTutorById(postgraduate.getTutor_id());
%>
    <p>学号：<%=participate.getPostgraduate_id()%></p><br>
    <p>姓名：<%=postgraduate.getName()%></p><br>
    <p>学科编号：<%=tutor.getSubject_id()%></p><br>
    <p>项目编号：<%=participate.getProject_id()%></p><br>
    <p>项目名称：<%=project.getName()%></p><br>
    <p>项目类型：<%=project.getType()%></p><br>
    <p>参与时段：<%=participate.getTime()%></p><br>
    <p>承担工作：<%=participate.getUndertake()%></p><br>
    <p>所得经费：<%=participate.getFunds()%>万元</p><br>
<%
    }
%>
<a href="postgraduate_index.jsp">返回</a>
</body>
</html>
