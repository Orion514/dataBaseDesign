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
    <title>配置学术交流次数</title>
  </head>
  <body>
  <h1 align="center">配置学术交流次数</h1>
  <br>
  <br>
  <h2 align="center">请输入本学科要求的学术交流次数</h2>

  <form action="Academic_Exchange_Count_Set" method="post">
  <div style="position:absolute;top:30%;left:30%;margin-left: 0px;margin-top: 0px">
    <label>学术交流活动次数：</label><input type="text" name="academic_exchange_count" /><br>

    <p align="center"><input type="submit" value="提交"/></p>
    </div>
  </form>

  </body>
</html>