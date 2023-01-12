<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page
    import="java.util.List"
    import="com.edu.dao.*"
    import="com.edu.dao.academic.*"
    import="com.edu.dao.academic.impl.*"
    import="com.edu.service.academic.*"
    import="java.text.SimpleDateFormat"

%>
<html>
  <head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>研究生学术交流情况认定</title>
  </head>
  <body>
  <h1 align="center">研究生学术交流情况认定</h1>
  <br>
  <br>
  <h2 align="center">请录入本次学术交流情况，以留存参会证明资料</h2>

  <form action="Academic_Exchange_Add" method="post">
  <div style="position:absolute;top:30%;left:30%;margin-left: 0px;margin-top: 0px">
    <label>学术交流活动名称：</label><input type="text" name="activity_name" /><br>
    <label>学术交流活动名称：</label><input type="text" name="activity_name" /><br>
    <label>活动地点(具体位置)：</label><input type="text" name="location" /><br>
    <label>活动时间：</label><input type="datetime-local" step="1" name="time" /><br>
    <label>报告中英文名称：</label><input type="text" name="report_name" /><br>
    <label>参会证明图片：</label><input type="file" name="image" /><br>
    <label>备注：</label><input type="text" name="notes" /><br>
    <p align="center"><input type="submit" value="提交"/></p>
    </div>
  </form>

  </body>
</html>