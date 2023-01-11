<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page
    import="java.util.List"
    import="java.util.ArrayList"
    import="com.edu.dao.*"
    import="com.edu.po.*"
    import="com.edu.dao.academic_exchange.*"
    import="com.edu.service.academic.*"
    import="java.text.SimpleDateFormat"

%>
<%@ page import="com.edu.domain.academic.Academic_Exchange" %>
<html>
  <head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>研究生学术交流情况认定</title>
  </head>
  <body>
  <h1 align="center">研究生学术交流情况认定</h1>
  <br>
  <br>
  <%
    User user=(User)session.getAttribute("userbean");
    int user_id=user.getId();
    TutorDaoImpl td=new TutorDaoImpl();
    Tutor tutor=td.selectTutorByUserId(user_id);
    PostgraduateDaoImpl pd=new PostgraduateDaoImpl();
    List<Postgraduate> students=pd.selectPostgraduateByTutorId(tutor.getId());
  %>
  <h2 align="center">请根据学科学术交流质量评价相关标准，审核该学术交流是否有效</h2>
    <form action="Academic_Exchange_Audit" method="post">
      <%
        List<String> audit_student_ids=new ArrayList<>();
        for(Postgraduate student:students){
      %>
        <p align="left" style="margin-left:150px">学生姓名：<%=student.getName()%></p>
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
                    if(l.getStudent_id().equals(student.getId())&&l.getAudit_result()!=null&&l.getAudit_result().equals("待审核")){
                        if(!audit_student_ids.contains(student.getId())){
                            audit_student_ids.add(student.getId());
                        }
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
                        s+="</tr>";
                    }
                }
                out.print(s);
                session.setAttribute("audit_student_ids", audit_student_ids);
              %>
              </table>
              <p align="center">请认定学术交流是否有效</p>
              <p align="center">
              <% String audit_result="audit_result"+student.getId(); %>
              <label>有效</label><input type="radio" name=<%=audit_result%> value="有效">
              <label>无效</label><input type="radio" name=<%=audit_result%> value="无效">
              </p>
              <br>

      <%
        }
      %>

      <p align="center"><input type="submit" value="确认"></p>
      </form>
  </body>
</html>