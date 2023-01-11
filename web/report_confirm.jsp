<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2023/1/11
  Time: 7:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>报告认证申请</title>
</head>
<body>
<form action="do_report_confirm" method="post">
  <p>报告名称<input type="text" name="name"></p>
  <p>报告类型
    <select name="type">
      <option>规划类</option>
      <option>设计类</option>
      <option>服务类</option>
      <option>其他</option>
    </select>
  </p>
  <p>报告服务单位<input type="text" name="dept"></p>
  <p>报告时间<input type="text" name="time"></p>
  <p>贡献度排名<input type="text" name="rank"></p>
  <p><input type="submit" value="提交"></p>
</form>
</body>
</html>
