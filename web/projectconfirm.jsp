<%@ page import="com.edu.dao.base.DaoFactory" %>
<%@ page import="java.util.List" %>
<%@ page import="com.edu.po.*" %>
<%@ page import="com.edu.domain.project.Participate" %>
<%@ page import="com.edu.domain.common.Postgraduate" %>
<%@ page import="com.edu.domain.common.Tutor" %>
<%@ page import="com.edu.domain.common.User" %><%--
  Created by IntelliJ IDEA.
  User: 2020
  Date: 2023/1/9
  Time: 17:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>导师确认签字</title>
</head>
<body>
<%
    User user=(User)session.getAttribute("userbean");
    int user_id=user.getId();
    //通过user_id查找tutor_id
    Tutor tutor= DaoFactory.getInstance().getTutorDao().selectTutorByUserId(user_id);
    List<Participate> participates=DaoFactory.getInstance().getParticipateDao().getAllParticipate();
%>
<p>等待导师项目审核认定的研究生如下：</p><br>
<table border="1">
    <thead>
    <tr>
        <td>研究生学号</td>
        <td>项目编号</td>
        <td>参与时段</td>
        <td>承担工作</td>
    </tr>
    </thead>
    <%
        for(Participate participate:participates){
            List<Postgraduate> postgraduates=DaoFactory.getInstance().getPostgraduateDao().selectPostgraduateByTutorId(tutor.getId());
            Postgraduate postgraduate=DaoFactory.getInstance().getPostgraduateDao().selectPostgraduateById(participate.getPostgraduate_id());
            int inPgs=0;    //participate当前表项的研究生是该导师的学生
            for(Postgraduate mypg:postgraduates){
                if(mypg.getId().equals(postgraduate.getId())){
                    inPgs=1;break;
                }
            }

            if(inPgs==1&&participate.getFunds()<=0.0001&&participate.getTime()!=null&&participate.getUndertake()!=null&&!participate.getTime().equals("")&&!participate.getUndertake().equals("")){
    %>
    <tbody>
    <tr>
        <td><%=participate.getPostgraduate_id()%></td>
        <td><%=participate.getProject_id()%></td>
        <td><%=participate.getTime()%></td>
        <td><%=participate.getUndertake()%></td>
    </tr>
    </tbody>
    <%
            }
        }
    %>
</table>
<br>
<p>导师审核认定，并给予学生研究经费</p>
<form method="post" action="${pageContext.request.contextPath}/ProjectConfirmByTutor">
    <label>学&nbsp;&nbsp;号</label>
    <input type="text" id="pgid" name="pgid"/><br>
    <label>项目编号</label>
    <input type="text" id="project_id" name="project_id"/><br>
    <label>经&nbsp;&nbsp;费</label>
    <input type="text" id="funds" name="funds"/><br>
    <input type="submit" value="确&nbsp;&nbsp;&nbsp;&nbsp;定"/>

</form>

<a href="tutor_index.jsp">返回</a>

</body>
</html>
