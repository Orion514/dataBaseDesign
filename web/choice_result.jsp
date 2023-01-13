<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>请进入审核页面</title>
</head>
<body>



<H1 align="center"><font color="black">志愿审核结果如下</font></H1>

<%

out.println("<table border=\"1\" align='center'>\r\n"+
		" <tr><th>研究生学号</th>\r\n" +"<th>"+"课程号"+"</th>\r\n"+"<th>"+"课程名"+"</th>\r\n"+"<th>"+"课程性质"+"</th>\r\n"+"<th>"+"授课对象"+"</th>\r\n"+"<th>"+"学科号"+"</th>\r\n"+"<th>"+"授课时间"+"</tr>\r\n"

		);

String result_sno=(String)session.getAttribute("result_sno");

for(int i=0;i<(Integer)session.getAttribute("result_num");i++)
{
	//String result_sno_id=(String)session.getAttribute(String.valueOf(i)+"result_sno_id");
	//String result_cid=(String)session.getAttribute(String.valueOf(i)+"result_cid");


	for(int j=0;j<(Integer)session.getAttribute(String.valueOf(i)+"result_num");j++)
	{
		String result_cid=(String)session.getAttribute(String.valueOf(i)+String.valueOf(j)+"result_cid");
		String result_name=(String)session.getAttribute(String.valueOf(i)+String.valueOf(j)+"result_name");
		String result_property=(String)session.getAttribute(String.valueOf(i)+String.valueOf(j)+"result_property");
		String result_teach_object=(String)session.getAttribute(String.valueOf(i)+String.valueOf(j)+"result_teach_object");
		String result_subject_id=(String)session.getAttribute(String.valueOf(i)+String.valueOf(j)+"result_subject_id");
		String result_hour=(String)session.getAttribute(String.valueOf(i)+String.valueOf(j)+"result_hour");


		out.println(" <tr>"+"<td>"+result_sno+"</td>\r\n" + "<td>"+result_cid+"</td>\r\n"+"<td>"+result_name+"</td>\r\n"+"<td>"+result_property+"</td>\r\n"+"<td>"+result_teach_object+"</td>\r\n"+"<td>"+result_subject_id+"</td>\r\n"+"<td>"+result_hour+"</td>\r\n"+"</tr>\r\n");
	}

	//out.println("<font color=\"Green\">订单号：  "+order_id+"商品号：  "+product_id+"用户id:  "+user_id+"下单时间:  "+time+"</font>"+"<br/>");
	/*out.println(
			" <tr><th>订单号</th>\r\n" + "<td>"+order_id+"</td>\r\n"+"</tr>\r\n"+
			" <tr><th>商品号</th>\r\n" + "<td>"+product_id+"</td>\r\n"+"</tr>\r\n"+
			"<tr><th>用户id</th>\r\n" + "<td>"+user_id+"</td>\r\n"+"</tr>\r\n"+
			"<tr><th>时间</th>\r\n" + "<td>"+time+"</td>\r\n"+"</tr>\r\n");*/
}

	out.println("</table>");

%>

</body>
</html>