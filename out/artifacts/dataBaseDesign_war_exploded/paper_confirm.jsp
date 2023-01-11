<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2023/1/11
  Time: 4:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>论文认定申请</title>
</head>
<body>
    <form action="do_paper_confirm" method="post">
        <p>论文名称<input type="text" name="paper_name"></p>
        <p>刊物名称<input type="text" name="press_name"></p>
        <select name="status">
            <option>录用未发表</option>
            <option>已发表</option>
        </select>
        <p>发表时间<input type="text" name="time"></p>
        <p>索引类型<input type="text" name="type"></p>
        <p>论文归属情况
            <select name="lib">
                <option>学院高质量论文库</option>
                <option>学院核心论文库</option>
            </select>
        </p>
        <p><input type="submit" value="提交"></p>
    </form>
</body>
</html>
