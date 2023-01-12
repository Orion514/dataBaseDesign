<%@ page import="com.edu.dao.common.SubjectDao" %>
<%@ page import="com.edu.dao.base.DaoFactory" %>
<%@ page import="com.edu.domain.common.Subject" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Orion
  Date: 2023-01-12
  Time: 9:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>研究生助教评定表填写系统</title>
</head>
<body>
<center>
    <h1>研究生助教评定表填写系统</h1>
    <br>

    <form action="assistant_stu_assessment" method="get">
        <div style="position:absolute;top:30%;left:30%;margin-left: 0px;margin-top: 0px">
            <label>研究生学号：</label><input type="text" name="stu_id" /><br>
            <label>研究生姓名：</label><input type="text" name="stu_name" /><br>
            <label>研究生所在学科:</label>
                <select name="stu_subject_name">
                    <%
                        String s = "";
                        SubjectDao subjectDao = DaoFactory.getInstance().getSubjectDao();
                        List<Subject> list = subjectDao.selectallSubject();
                        for(Subject sub : list){
                            s += "<option>";
                            s += sub.getName();
                            s += "</option>";
                        }
                        out.print(s);
                    %>
                </select>
            <br>
            <label>课程名称：</label><input type="text" name="course_name" /><br>
            <label>课程性质：</label><input type="text" name="course_property" /><br>
            <label>授课对象：</label><input type="text" name="course_object" /><br>
            <label>授课教师：</label><input type="text" name="teacher_name" /><br>
            <label>授课人数：</label><input type="text" name="teach_student_num" /><br>
            <label>授课时间：</label><input type="text" name="teach_time"/><br>
            <label>助教工作自述：</label><input type="text" name="work_statement"/><br>
            <p align="center"><input type="submit" value="提交"/></p>
            <p align="center"><a href="postgraduate_index.jsp">返回</a></p>
        </div>
    </form>
</center>
</body>
</html>
