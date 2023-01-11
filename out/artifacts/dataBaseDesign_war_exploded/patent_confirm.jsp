<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2023/1/11
  Time: 7:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>专利认证申请</title>
</head>
<body>
<form action="do_patent_confirm" method="post">
  <p>专利名称<input type="text" name="name"></p>
  <p>专利类型
    <select name="type">
      <option>发明专利</option>
      <option>使用新型专利</option>
    </select>
  </p>
  <p>专利号<input type="text" name="patent_no"></p>
  <p>发布时间<input type="text" name="time"></p>
  <p>专利状态<input type="text" name="status"></p>
  <p>贡献度排名<input type="text" name="rank"></p>
  <p><input type="submit" value="提交"></p>
</form>
</body>
</html>
