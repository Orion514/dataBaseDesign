<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>请进入审核页面</title>
</head>
<body>

<p align="center">
<H1><font color="black">该条信息如下</font></H1>



<p align="center">
研究生学号: <%=(String)request.getParameter("assess_sno_idd") %>

<p align="center">
课程教师ID：<%=(String)request.getParameter("assess_course_teacher_idd") %>

<%
request.getSession().setAttribute("assess_sno_id", (String)request.getParameter("assess_sno_idd"));
request.getSession().setAttribute("assess_course_teacher_id", (String)request.getParameter("assess_course_teacher_idd"));

%>
<form method="post" action="GetAssessEvaluation">

<p align="center">
授课教师评价：
<input type="text" name="teacher_appraise">

<p align="center">
评价时间：
<input type="date" name="appraise_time" size="20" value="">

<p align="center">
评价结果：
<select  name="appraise_result"  size="1">
	<option value="合格"  selected > 合格 </option>
	<option value="不合格" > 不合格 </option>
</select> </p> 


<p align="center">
 <input type="submit" value="提交">   

</form>

</body>
</html>