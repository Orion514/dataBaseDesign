<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page
    import="java.util.List"
    import="com.edu.dao.*"
    import="com.edu.po.*"
    import="com.edu.dao.academic_exchange.*"
    import="com.edu.service.academic.*"
    import="java.text.SimpleDateFormat"
    import="javax.servlet.http.HttpServletRequest"
    import="javax.servlet.http.HttpSession"
%>
<%@ page import="com.edu.domain.academic.Academic_Exchange" %>
<html>
  <head>
    <title>研究生学术交流情况认定</title>
    <script>
        alert("您选择的学科交流次数与本学科的要求不相符，请重新选择")
    </script>
  </head>
  <body>
  <h1 align="center">研究生学术交流情况认定</h1>
  <br>
  <br>
  <%
    User user=(User)session.getAttribute("userbean");
    int user_id=user.getId();
    PostgraduateDaoImpl pd=new PostgraduateDaoImpl();
    Postgraduate student=pd.selectPostgraduateByUserId(user_id);
    String student_id=student.getId();
    String subject_leader_id="";
     Academic_ExchangeDaoImpl ae1=new Academic_ExchangeDaoImpl();
        List<Academic_Exchange> list1=ae1.selectAcademic_Exchange();
        for(Academic_Exchange l:list1){
            if(l.getStudent_id().equals(student_id)){
                subject_leader_id=l.getSubject_leader_id();
                break;
                }
            }
    Subject_LeaderDaoImpl sldao=new Subject_LeaderDaoImpl();
    Subject_Leader sl=sldao.SelectSubject_LeaderById(subject_leader_id);
    String subject_id=sl.getSubject_id();
    SubjectDaoImpl sdao=new SubjectDaoImpl();
    Subject subject=sdao.selectSubject(subject_id);
    int count=subject.getAcademic_exchange_count();
    session.setAttribute("academic_exchange_count", count);
    String strcount=String.valueOf(count);
  %>
  <h2 align="center">请选择<%=strcount%>次国内或国际学术交流情况，提交至导师处审核</h2>
  <form action="Academic_Exchange_Select" method="post">
  <table width="1000" cellspacing="10" frame="box" align="center">
  <thead>
  <tr align="center">
  <th>序号</th>
  <th>学术交流活动名称</th>
  <th>活动地点(具体位置)</th>
  <th>活动时间</th>
  <th>报告中英文名称</th>
  <th>参会证明图片</th>
  <th>备注</th>
  </tr>
  </thead>
  <%
    Academic_ExchangeDaoImpl ae=new Academic_ExchangeDaoImpl();
    List<Academic_Exchange> list=ae.selectAcademic_Exchange();
    String s="";
    int i=1;
    for(Academic_Exchange l:list){
        if(l.getStudent_id().equals(student_id)){
            s+="<tr align=\"center\">";
            s+="<td>"+String.valueOf(i)+"</td>";
            i++;
            s+="<td>"+l.getActivity_name()+"</td>";
            s+="<td>"+l.getLocation()+"</td>";
            SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String strDate4 = sdf4.format(l.getTime());
            s+="<td>"+strDate4+"</td>";
            s+="<td>"+l.getReport_name()+"</td>";
            String src="image/"+l.getImage();
            s+="<td><img src=\""+src+"\"width=\"100\" height=\"100\"></td>";
            s+="<td>"+l.getNotes()+"</td>";
            s+="<td>"+"<input type=\"checkbox\" name=\"selected_academic_exchange\" value="+l.getNo()+">"+"</td>";
            s+="</tr>";
        }
    }
    out.print(s);
  %>
  </table>
  <p align="center"><input type="submit" value="提交"></p>
  </form>
  </body>
</html>