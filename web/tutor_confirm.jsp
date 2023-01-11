<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2023/1/11
  Time: 12:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.edu.dao.*" %>
<%@ page import="com.edu.po.*" %>
<%@ page import="com.edu.dao.achievement.impl.*" %>
<%@ page import="com.edu.domain.achievement.*" %>
<%@ page import="com.edu.domain.common.User" %>
<html>
<head>
    <title>学生成果认证</title>
</head>
<body>
<center>
    <table>
        <%
            User user = (User) session.getAttribute("userbean");
            PaperDaoImpl paperDao = new PaperDaoImpl();
            List<Paper> papers = paperDao.selectAll();
            if(!papers.isEmpty()){
        %>
        <tr>
            <td>序号</td>
            <td>论文名</td>
            <td>刊物名称</td>
            <td>状态</td>
            <td>发表时间</td>
            <td>索引类型</td>
            <td>归属库</td>
            <td>审核状态</td>
            <td></td>
        </tr>
        <%
            for(Paper paper:papers){
        %>
    <form action="doPaper" method="post">
        <tr>
            <td><%=paper.getId()%></td>
            <td><%=paper.getPaper_name()%></td>
            <td><%=paper.getPress_name()%></td>
            <td><%=paper.getStatus()%></td>
            <td><%=paper.getTime()%></td>
            <td><%=paper.getType()%></td>
            <td><%=paper.getLib()%></td>
            <td>
                <select name = "result">
                    <%
                        if(paper.getResult().equals("待审核")){
                    %>
                    <option selected>待审核</option>
                    <option>已通过</option>
                    <option>已拒绝</option>
                    <%
                        }
                        else if(paper.getResult().equals("已通过")){
                            %>
                    <option>待审核</option>
                    <option selected>已通过</option>
                    <option>已拒绝</option>
                    <%
                        }
                        else{
                            %>
                    <option>待审核</option>
                    <option>已通过</option>
                    <option selected>已拒绝</option>
                    <%
                        }
                    %>
                </select>
            </td>
            <input type="hidden" name="id" value=<%=paper.getId()%>>
            <td><input type="submit" value="提交"></td>
        </tr>
    </form>
        <%
            }
        %>
        <p>========================================================================</p>
        <%
            }
        %>
    </table>

    <table>
        <%
            PrizeDaoImpl prizeDao = new PrizeDaoImpl();
            List<Prize> prizes = prizeDao.selectAll();
            if(!prizes.isEmpty()){
        %>
        <tr>
            <td>序号</td>
            <td>奖励名称</td>
            <td>奖励等级</td>
            <td>获奖等级</td>
            <td>排名</td>
            <td>获奖时间</td>
            <td>审核状态</td>
        </tr>
        <%
            for(Prize prize:prizes){
        %>
    <form action="doPrize" method="post">
        <tr>
            <td><%=prize.getId()%></td>
            <td><%=prize.getName()%></td>
            <td><%=prize.getType()%></td>
            <td><%=prize.getPrize()%></td>
            <td><%=prize.getRank()%></td>
            <td><%=prize.getTime()%></td>
            <td>
                <select name = "result">
                    <%
                        if(prize.getResult().equals("待审核")){
                    %>
                    <option selected>待审核</option>
                    <option>已通过</option>
                    <option>已拒绝</option>
                    <%
                    }
                    else if(prize.getResult().equals("已通过")){
                    %>
                    <option>待审核</option>
                    <option selected>已通过</option>
                    <option>已拒绝</option>
                    <%
                    }
                    else{
                    %>
                    <option>待审核</option>
                    <option>已通过</option>
                    <option selected>已拒绝</option>
                    <%
                        }
                    %>
                </select>
            </td>
            <input type="hidden" name="id" value=<%=prize.getId()%>>
            <td><input type="submit" value="提交"></td>
        </tr>
    </form>
        <%
            }
        %>
        <p>========================================================================</p>
        <%
            }
        %>
    </table>

    <table>
        <%
            StandardDaoImpl standardDao = new StandardDaoImpl();
            List<Standard> standards = standardDao.selectAll();
            if(!standards.isEmpty()){
        %>
        <tr>
            <td>序号</td>
            <td>标准名称</td>
            <td>标准级别</td>
            <td>发布时间</td>
            <td>审核状态</td>
        </tr>
        <%
            for(Standard standard:standards){
        %>
    <form action="doStandard" method="post">
        <tr>
            <td><%=standard.getId()%></td>
            <td><%=standard.getStd_name()%></td>
            <td><%=standard.getType()%></td>
            <td><%=standard.getTime()%></td>
            <td>
                <select name = "result">
                    <%
                        if(standard.getResult().equals("待审核")){
                    %>
                    <option selected>待审核</option>
                    <option>已通过</option>
                    <option>已拒绝</option>
                    <%
                    }
                    else if(standard.getResult().equals("已通过")){
                    %>
                    <option>待审核</option>
                    <option selected>已通过</option>
                    <option>已拒绝</option>
                    <%
                    }
                    else{
                    %>
                    <option>待审核</option>
                    <option>已通过</option>
                    <option selected>已拒绝</option>
                    <%
                        }
                    %>
                </select>
            </td>
            <input type="hidden" name="id" value=<%=standard.getId()%>>
            <td><input type="submit" value="提交"></td>
        </tr>
    </form>
        <%
            }
        %>
        <p>========================================================================</p>
        <%
            }
        %>
    </table>

    <table>
        <%
            ReportDaoImpl reportDao = new ReportDaoImpl();
            List<Report> reports = reportDao.selectAll();
            if(!reports.isEmpty()){
        %>
        <tr>
            <td>序号</td>
            <td>报告名称</td>
            <td>报告类型</td>
            <td>服务单位</td>
            <td>报告时间</td>
            <td>贡献度排名</td>
            <td>审核状态</td>
        </tr>
        <%
            for(Report report:reports){
        %>
    <form action="doReport" method="post">
        <tr>
            <td><%=report.getId()%></td>
            <td><%=report.getName()%></td>
            <td><%=report.getType()%></td>
            <td><%=report.getDept()%></td>
            <td><%=report.getTime()%></td>
            <td><%=report.getRank()%></td>
            <td>
                <select name = "result">
                    <%
                        if(report.getResult().equals("待审核")){
                    %>
                    <option selected>待审核</option>
                    <option>已通过</option>
                    <option>已拒绝</option>
                    <%
                    }
                    else if(report.getResult().equals("已通过")){
                    %>
                    <option>待审核</option>
                    <option selected>已通过</option>
                    <option>已拒绝</option>
                    <%
                    }
                    else{
                    %>
                    <option>待审核</option>
                    <option>已通过</option>
                    <option selected>已拒绝</option>
                    <%
                        }
                    %>
                </select>
            </td>
            <input type="hidden" name="id" value=<%=report.getId()%>>
            <td><input type="submit" value="提交"></td>
        </tr>
    </form>
        <%
            }
        %>
        <p>========================================================================</p>
        <%
            }
        %>
    </table>

    <table>
        <%
            PatentDaoImpl patentDao = new PatentDaoImpl();
            List<Patent> patents = patentDao.selectAll();
            if(!patents.isEmpty()){
        %>
        <tr>
            <td>序号</td>
            <td>专利名称</td>
            <td>专利类型</td>
            <td>专利号</td>
            <td>发布时间</td>
            <td>专利状态</td>
            <td>贡献度排名</td>
            <td>审核状态</td>
        </tr>
        <%
            for(Patent patent:patents){
        %>
        <form action="doPatent" method="post">
        <tr>
            <td><%=patent.getId()%></td>
            <td><%=patent.getName()%></td>
            <td><%=patent.getType()%></td>
            <td><%=patent.getPatent_no()%></td>
            <td><%=patent.getTime()%></td>
            <td><%=patent.getStatus()%></td>
            <td><%=patent.getRank()%></td>
            <td>
                <select name = "result">
                    <%
                        if(patent.getResult().equals("待审核")){
                    %>
                    <option selected>待审核</option>
                    <option>已通过</option>
                    <option>已拒绝</option>
                    <%
                    }
                    else if(patent.getResult().equals("已通过")){
                    %>
                    <option>待审核</option>
                    <option selected>已通过</option>
                    <option>已拒绝</option>
                    <%
                    }
                    else{
                    %>
                    <option>待审核</option>
                    <option>已通过</option>
                    <option selected>已拒绝</option>
                    <%
                        }
                    %>
                </select>
            </td>
            <input type="hidden" name="id" value=<%=patent.getId()%>>
            <td><input type="submit" value="提交"></td>
        </tr>
        </form>
        <%
            }
        %>
        <p>========================================================================</p>
        <%
            }
        %>
    </table>

    <table>
        <%
            PlatformDaoImpl platformDao = new PlatformDaoImpl();
            List<Platform> platforms = platformDao.selectAll();
            if(!platforms.isEmpty()){
        %>
        <tr>
            <td>序号</td>
            <td>平台名称</td>
            <td>服务单位</td>
            <td>上线时间</td>
            <td>贡献度</td>
            <td>审核状态</td>
        </tr>
        <%
            for(Platform platform:platforms){
        %>
        <form action="doPlatform" method="post">
        <tr>
            <td><%=platform.getId()%></td>
            <td><%=platform.getName()%></td>
            <td><%=platform.getDept()%></td>
            <td><%=platform.getTime()%></td>
            <td><%=platform.getRank()%></td>
            <td>
                <select name = "result">
                    <%
                        if(platform.getResult().equals("待审核")){
                    %>
                    <option selected>待审核</option>
                    <option>已通过</option>
                    <option>已拒绝</option>
                    <%
                    }
                    else if(platform.getResult().equals("已通过")){
                    %>
                    <option>待审核</option>
                    <option selected>已通过</option>
                    <option>已拒绝</option>
                    <%
                    }
                    else{
                    %>
                    <option>待审核</option>
                    <option>已通过</option>
                    <option selected>已拒绝</option>
                    <%
                        }
                    %>
                </select>
            </td>
            <input type="hidden" name="id" value=<%=platform.getId()%>>
            <td><input type="submit" value="提交"></td>
        </tr>
        </form>
        <%
            }
        %>
        <p>========================================================================</p>
        <%
            }
        %>
    </table>

    <table>
        <%
            TextbookDaoImpl textbookDao = new TextbookDaoImpl();
            List<Textbook> textbooks = textbookDao.selectAll();
            if(!textbooks.isEmpty()){
        %>
        <tr>
            <td>序号</td>
            <td>教材名称</td>
            <td>出版社</td>
            <td>出版时间</td>
            <td>贡献度</td>
            <td>审核状态</td>
        </tr>
        <%
            for(Textbook textbook:textbooks){
        %>
        <form action="doTextbook" method="post">
        <tr>
            <td><%=textbook.getId()%></td>
            <td><%=textbook.getName()%></td>
            <td><%=textbook.getPress()%></td>
            <td><%=textbook.getTime()%></td>
            <td><%=textbook.getPoint()%></td>
            <td>
                <select name = "result">
                    <%
                        if(textbook.getResult().equals("待审核")){
                    %>
                    <option selected>待审核</option>
                    <option>已通过</option>
                    <option>已拒绝</option>
                    <%
                    }
                    else if(textbook.getResult().equals("已通过")){
                    %>
                    <option>待审核</option>
                    <option selected>已通过</option>
                    <option>已拒绝</option>
                    <%
                    }
                    else{
                    %>
                    <option>待审核</option>
                    <option>已通过</option>
                    <option selected>已拒绝</option>
                    <%
                        }
                    %>
                </select>
            </td>
            <input type="hidden" name="id" value=<%=textbook.getId()%>>
            <td><input type="submit" value="提交"></td>
        </tr>
        </form>
        <%
            }
        %>
        <p>========================================================================</p>
        <%
            }
        %>
    </table>
    <p>========================================================================</p>
</center>
</body>
</html>
