<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>第二志愿信息如下</title>
</head>
<body>

<p align="center">
<H1><font color="black">第二志愿信息如下</font></H1>



<%

out.println("<table border=\"1\" align='center'>\r\n"+
		" <tr><th>审核id</th>\r\n" + "<th>"+"研究生学号"+"</th>\r\n"+"<th>"+"课程号"+"</th>\r\n"+"<th>"+"状态"+"</th>\r\n"+"<th>"+"志愿"+"</th>\r\n"+"</tr>\r\n"
		
		);
for(int i=0;i<(Integer)session.getAttribute("list_choice2_num");i++)
{
	String list_choice2_id=(String)session.getAttribute(String.valueOf(i)+"list_choice2_id");
	String list_choice2_sno_id=(String)session.getAttribute(String.valueOf(i)+"list_choice2_sno_id");
	String list_choice2_cid=(String)session.getAttribute(String.valueOf(i)+"list_choice2_cid");
	String list_choice2_audit_state=(String)session.getAttribute(String.valueOf(i)+"list_choice2_audit_state");
	String list_choice2_choice=(String)session.getAttribute(String.valueOf(i)+"list_choice2_choice");
	

	//out.println("<font color=\"Green\">订单号：  "+order_id+"商品号：  "+product_id+"用户id:  "+user_id+"下单时间:  "+time+"</font>"+"<br/>");
	/*out.println(
			" <tr><th>订单号</th>\r\n" + "<td>"+order_id+"</td>\r\n"+"</tr>\r\n"+
			" <tr><th>商品号</th>\r\n" + "<td>"+product_id+"</td>\r\n"+"</tr>\r\n"+
			"<tr><th>用户id</th>\r\n" + "<td>"+user_id+"</td>\r\n"+"</tr>\r\n"+
			"<tr><th>时间</th>\r\n" + "<td>"+time+"</td>\r\n"+"</tr>\r\n");*/
	out.println(" <tr>"+"<td>"+list_choice2_id+"</td>\r\n" + "<td>"+list_choice2_sno_id+"</td>\r\n"+"<td>"+list_choice2_cid+"</td>\r\n"+"<td>"+list_choice2_audit_state+"</td>\r\n"+"<td>"+list_choice2_choice+"</td>\r\n"+"<td>"+"<a HREF='agree_chooice?list_choice2_idd="+list_choice2_id+"'>"+"通过"+"</a>"+"</td>\r\n"+"<td>"+"<a HREF='disagree_chooice?list_choice2_idd="+list_choice2_id+"'>"+"不通过"+"</a>"+"</td>\r\n"+"</tr>\r\n");
}

	out.println("</table>");

%>

</body>
</html>