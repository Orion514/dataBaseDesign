
<%@ page contentType="text/html;charset=UTF-8" language="java"

%>
<%@ page import="com.edu.dao.base.DaoFactory" %>
<%@ page import="java.util.List" %>
<%@ page import="com.edu.po.*" %>
<html>
<head>
    <title>导师指定项目给学生</title>
</head>
<body>
<%
    User user=(User)session.getAttribute("userbean");
    int user_id=user.getId();
    //通过user_id查找tutor_id
    Tutor tutor= DaoFactory.getInstance().getTutorDao().selectTutorByUserId(user_id);
    //通过tutor_id在project表中查找该导师的所有项目
    List<Project> projects=DaoFactory.getInstance().getProjectDao().selectProjectByTutorId(tutor.getId());
    List<Postgraduate> postgraduates=DaoFactory.getInstance().getPostgraduateDao().selectPostgraduateByTutorId(tutor.getId());
%>
<p>剩余经费大于12万的项目可供选择</p>
<table border="1">
    <thead>
    <tr>
        <th>项目编号</th>
        <th>项目名称</th>
        <th>项目类型</th>
        <th>项目经费</th>
        <th>剩余经费</th>
    </tr>
    </thead>
    <%
        for(Project proj:projects){
            if(proj.getSurplus_funds()>12.0){
    %>
    <tbody>
    <tr>
        <td><%=proj.getIdentifier()%></td>
        <td><%=proj.getName()%></td>
        <td><%=proj.getType()%></td>
        <td><%=proj.getFunds()%></td>
        <td><%=proj.getSurplus_funds()%></td>
    </tr>
    </tbody>
    <%
            }
        }
    %>
</table>
<br><br>
<p>当前该导师的无项目的研究生</p>
<table border="1">
    <thead>
    <tr>
        <td>学号</td>
        <td>姓名</td>
    </tr>
    </thead>
    <%
        for(Postgraduate postgraduate:postgraduates){
            Participate participate=DaoFactory.getInstance().getParticipateDao().getParticipateByPostgraduateId(postgraduate.getId());

            if(participate==null){
    %>
    <tbody>
    <tr>
        <td><%=postgraduate.getId()%></td>
        <td><%=postgraduate.getName()%></td>
    </tr>
    </tbody>
    <%
            }
        }
    %>
</table>
<br><br>
<form method="post" action="${pageContext.request.contextPath}/AddParticipate">
    <label>学&nbsp;&nbsp;号</label>
    <input type="text" id="pgid" name="pgid"/><br>
    <label>项目编号</label>
    <input type="text" id="project_id" name="project_id"/><br>
    <input type="submit" value="指派"/>
</form>
<a href="tutor_index.jsp">返回</a>
</body>
</html>
