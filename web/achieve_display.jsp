<%@ page import="java.util.List" %>
<%@ page import="com.edu.dao.*" %>
<%@ page import="com.edu.po.*" %>
<%@ page import="com.edu.dao.achievement.impl.*" %>
<%@ page import="com.edu.domain.achievement.*" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2023/1/11
  Time: 9:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>我的认证</title>
</head>
<body>
<center>
    <table>
    <%
        User user = (User) session.getAttribute("userbean");
        PaperDaoImpl paperDao = new PaperDaoImpl();
        List<Paper> papers = paperDao.selectPaperByUserid(user.getId());
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
        </tr>
        <%
        for(Paper paper:papers){
    %>
        <tr>
            <td><%=paper.getId()%></td>
            <td><%=paper.getPaper_name()%></td>
            <td><%=paper.getPress_name()%></td>
            <td><%=paper.getStatus()%></td>
            <td><%=paper.getTime()%></td>
            <td><%=paper.getType()%></td>
            <td><%=paper.getLib()%></td>
            <td><%=paper.getResult()%></td>
        </tr>
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
            List<Prize> prizes = prizeDao.selectPrizeByUserid(user.getId());
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
        <tr>
            <td><%=prize.getId()%></td>
            <td><%=prize.getName()%></td>
            <td><%=prize.getType()%></td>
            <td><%=prize.getPrize()%></td>
            <td><%=prize.getRank()%></td>
            <td><%=prize.getTime()%></td>
            <td><%=prize.getResult()%></td>
        </tr>
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
            List<Standard> standards = standardDao.selectStandardByUserid(user.getId());
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
        <tr>
            <td><%=standard.getId()%></td>
            <td><%=standard.getStd_name()%></td>
            <td><%=standard.getType()%></td>
            <td><%=standard.getTime()%></td>
            <td><%=standard.getResult()%></td>
        </tr>
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
            List<Report> reports = reportDao.selectReportByUserId(user.getId());
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
        <tr>
            <td><%=report.getId()%></td>
            <td><%=report.getName()%></td>
            <td><%=report.getType()%></td>
            <td><%=report.getDept()%></td>
            <td><%=report.getTime()%></td>
            <td><%=report.getRank()%></td>
            <td><%=report.getResult()%></td>
        </tr>
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
            List<Patent> patents = patentDao.selectPatentByUserid(user.getId());
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
        <tr>
            <td><%=patent.getId()%></td>
            <td><%=patent.getName()%></td>
            <td><%=patent.getType()%></td>
            <td><%=patent.getPatent_no()%></td>
            <td><%=patent.getTime()%></td>
            <td><%=patent.getStatus()%></td>
            <td><%=patent.getRank()%></td>
            <td><%=patent.getResult()%></td>
        </tr>
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
            List<Platform> platforms = platformDao.selectPlatformByUserid(user.getId());
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
        <tr>
            <td><%=platform.getId()%></td>
            <td><%=platform.getName()%></td>
            <td><%=platform.getDept()%></td>
            <td><%=platform.getTime()%></td>
            <td><%=platform.getRank()%></td>
            <td><%=platform.getResult()%></td>
        </tr>
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
            List<Textbook> textbooks = textbookDao.selectTextbookByUserid(user.getId());
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
        <tr>
            <td><%=textbook.getId()%></td>
            <td><%=textbook.getName()%></td>
            <td><%=textbook.getPress()%></td>
            <td><%=textbook.getTime()%></td>
            <td><%=textbook.getPoint()%></td>
            <td><%=textbook.getResult()%></td>
        </tr>
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
