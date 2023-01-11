<%@ page import="com.edu.dao.assistant.CourseTeacherDao" %>
<%@ page import="com.edu.dao.assistant.impl.CourseTeacherDaoImpl" %>
<%@ page import="com.edu.domain.assistant.CourseTeacherView" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Orion
  Date: 2023-01-11
  Time: 15:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>研究生助教志愿申请（第一志愿）</title>
</head>
<body>
<h1 align="center">研究生助教志愿申请（第一志愿）</h1>
<br>
<br>

<table width="1000" cellspacing="10" frame="box" align="center">
    <thead>
    <tr align="center">
        <th>序号</th>
        <th>课程名</th>
        <th>课程性质</th>
        <th>课程时长</th>
        <th>授课对象</th>
        <th>授课教师</th>
        <th>选课人数</th>
    </tr>
    </thead>

<%
    CourseTeacherDao ctDao = new CourseTeacherDaoImpl();
    List<CourseTeacherView> list = ctDao.getCourseTeacherAll();
    String s="";
    for(CourseTeacherView l:list){
        s+="<tr align=\"center\">";
        s+="<td>"+l.getId()+"</td>";
        s+="<td>"+l.getCourse_name()+"</td>";
        s+="<td>"+l.getCourse_property()+"</td>";
        s+="<td>"+l.getCourse_hour()+"</td>";
        s+="<td>"+l.getCourse_teach_object()+"</td>";
        s+="<td>"+l.getTeacher_name()+"</td>";
        s+="<td>"+l.getTeach_student_num()+"</td>";
        s+="</tr>";
    }
    out.print(s);
%>
</table>

<center>
<form action="assistant_stu_1" method="get">
    <p>第一志愿（序号）：
        <select name = "selectId">
            <%
                String ss = "";
                for(CourseTeacherView l: list){
                    ss+="<option value=\"";
                    ss+=l.getId();
                    ss+="\">";
                    ss+=l.getId();
                    ss+="</option>";
                }
                out.print(ss);
            %>
        </select>
    </p>
    <p align="center"><input type="submit" value="提交"></p>
</form>
</center>

</body>
</html>
