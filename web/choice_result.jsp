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
<H1><font color="black">志愿审核结果如下</font></H1>

<%

out.println("<table border=\"1\" align='center'>\r\n"+
		" <tr><th>研究生学号</th>\r\n" + "<th>"+"课程号"+"</th>\r\n"+"</tr>\r\n"
		
		);
for(int i=0;i<(Integer)session.getAttribute("result_num");i++)
{
	String result_sno_id=(String)session.getAttribute(String.valueOf(i)+"result_sno_id");
	String result_cid=(String)session.getAttribute(String.valueOf(i)+"result_cid");
	

	//out.println("<font color=\"Green\">订单号：  "+order_id+"商品号：  "+product_id+"用户id:  "+user_id+"下单时间:  "+time+"</font>"+"<br/>");
	/*out.println(
			" <tr><th>订单号</th>\r\n" + "<td>"+order_id+"</td>\r\n"+"</tr>\r\n"+
			" <tr><th>商品号</th>\r\n" + "<td>"+product_id+"</td>\r\n"+"</tr>\r\n"+
			"<tr><th>用户id</th>\r\n" + "<td>"+user_id+"</td>\r\n"+"</tr>\r\n"+
			"<tr><th>时间</th>\r\n" + "<td>"+time+"</td>\r\n"+"</tr>\r\n");*/
	out.println(" <tr>"+"<td>"+result_sno_id+"</td>\r\n" + "<td>"+result_cid+"</td>\r\n"+"</tr>\r\n");
}

	out.println("</table>");

%>

</body>
</html>