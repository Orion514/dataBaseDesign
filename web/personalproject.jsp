<%@ page contentType="text/html;charset=UTF-8" language="java"
    import="com.edu.po.User"
%>
<%@ page import="com.edu.po.Tutor" %>
<%@ page import="com.edu.dao.base.DaoFactory" %>
<%@ page import="com.edu.domain.project.Project" %>
<%@ page import="java.util.List" %>
<html>
<head>
    <title>导师查看自己负责的项目</title>
</head>
<body>
<%
    User user=(User)session.getAttribute("userbean");
    int user_id=user.getId();
    //通过user_id查找tutor_id
    Tutor tutor= DaoFactory.getInstance().getTutorDao().selectTutorByUserId(user_id);
    //通过tutor_id在project表中查找该导师的所有项目
    List<Project> projects=DaoFactory.getInstance().getProjectDao().selectProjectByTutorId(tutor.getId());
%>
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
        %>
    </table>
    <br>
    <a href="tutor_index.jsp">返回</a>
</body>
</html>
