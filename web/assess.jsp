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
<H1><font color="black">助教评定信息如下</font></H1>

<%

out.println("<table border=\"1\" align='center'>\r\n"+
		" <tr><th>研究生学号</th>\r\n" + "<th>"+"课程教师表ID"+"</th>\r\n"+"<th>"+"助教工作自述"+"</th>\r\n"+"<th>"+"自述时间"+"</th>\r\n"+"<th>"+"评定"+"</th>\r\n"+"</tr>\r\n"
		
		);
for(int i=0;i<(Integer)session.getAttribute("assess_num");i++)
{
	String assess_sno_id=(String)session.getAttribute(String.valueOf(i)+"assess_sno_id");
	String assess_course_teacher_id=(String)session.getAttribute(String.valueOf(i)+"assess_course_teacher_id");
	String assess_work_statement=(String)session.getAttribute(String.valueOf(i)+"assess_work_statement");
	String assess_statement_time=(String)session.getAttribute(String.valueOf(i)+"assess_statement_time");
	

	//out.println("<font color=\"Green\">订单号：  "+order_id+"商品号：  "+product_id+"用户id:  "+user_id+"下单时间:  "+time+"</font>"+"<br/>");
	/*out.println(
			" <tr><th>订单号</th>\r\n" + "<td>"+order_id+"</td>\r\n"+"</tr>\r\n"+
			" <tr><th>商品号</th>\r\n" + "<td>"+product_id+"</td>\r\n"+"</tr>\r\n"+
			"<tr><th>用户id</th>\r\n" + "<td>"+user_id+"</td>\r\n"+"</tr>\r\n"+
			"<tr><th>时间</th>\r\n" + "<td>"+time+"</td>\r\n"+"</tr>\r\n");*/
	out.println(" <tr>"+"<td>"+assess_sno_id+"</td>\r\n" + "<td>"+assess_course_teacher_id+"</td>\r\n"+"<td>"+assess_work_statement+"</td>\r\n"+"<td>"+assess_statement_time+"</td>\r\n"+"<td>"+"<a HREF='assess_evaluation.jsp?assess_sno_idd="+assess_sno_id+"&assess_course_teacher_idd="+assess_course_teacher_id+"'>"+"评定"+"</a>"+"</td>\r\n"+"</tr>\r\n");
}

	out.println("</table>");

%>


</body>
</html>