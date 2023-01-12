<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2023/1/11
  Time: 6:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>奖励认定申请</title>
</head>
<body>
<form action="do_prize_confirm" method="post">
  <p>奖励名称<input type="text" name="prize_name"></p>
  <p>奖励等级
    <select name="type">
      <option>国家级</option>
      <option>省部级</option>
      <option>市级</option>
      <option>其他</option>
    </select>
  </p>
  <p>获奖等级
    <select name="prize">
      <option>特等奖</option>
      <option>一等奖</option>
      <option>二等奖</option>
      <option>三等奖</option>
    </select>
  </p>
  <p>排名<input type="text" name="rank"></p>
  <p>获奖时间<input type="text" name="time"></p>
  <p><input type="submit" value="提交"></p>
</form>
</body>
</html>
