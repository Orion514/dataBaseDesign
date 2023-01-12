<%@ page import="com.edu.domain.common.User" %>
<%@ page import="com.edu.domain.common.Postgraduate" %>
<%@ page import="com.edu.dao.base.DaoFactory" %>
<%@ page import="com.edu.domain.project.Participate" %><%--
  Created by IntelliJ IDEA.
  User: 2020
  Date: 2023/1/9
  Time: 17:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>填写认定表</title>
</head>
<body>
<%String result="";%>
<%
    User user=(User)session.getAttribute("userbean");
    int user_id=user.getId();
    Postgraduate postgraduate= DaoFactory.getInstance().getPostgraduateDao().selectPostgraduateByUserId(user_id);
    Participate participate=DaoFactory.getInstance().getParticipateDao().getParticipateByPostgraduateId(postgraduate.getId());
    if(participate==null){
        result="当前未参与项目";
    }
    else if(participate.getFunds()<=0.0001&&participate.getTime()==null&&participate.getUndertake()==null){
        result="未完成项目认定";
    }
    else{
        result="已完成认定表的填写，无需再填";
    }
%>
<%
    if(result.equals("当前未参与项目")){
%>
        <P>当前未参与项目，无需填表</P>
<%
    }
    else if(result.equals("已完成认定表的填写，无需再填")){
%>
        <p>已完成认定表的填写，无需再填</p>
<%
    }
    else{
%>

<form method="post" action="${pageContext.request.contextPath}/ProjectSubmitByPG">
    <label>参与时段</label>
    <input type="text" id="time" name="time"/><br>
    <label>承担工作</label>
    <input type="text" id="undertake" name="undertake"/><br>
    <input type="submit" value="提&nbsp;&nbsp;&nbsp;&nbsp;交"/>

</form>
<%
    }
%>
<a href="postgraduate_index.jsp">返回</a>
</body>
</html>
