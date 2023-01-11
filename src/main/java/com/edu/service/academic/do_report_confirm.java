package com.edu.service.academic;

import com.edu.dao.ReportDaoImpl;
import com.edu.dao.StandardDaoImpl;
import com.edu.po.Report;
import com.edu.po.Standard;
import com.edu.po.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/do_report_confirm")
public class do_report_confirm extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("userbean");
        String name = request.getParameter("name").toString();
        String type = request.getParameter("type").toString();
        String dept = request.getParameter("dept").toString();
        String time = request.getParameter("time").toString();
        int rank = Integer.parseInt(request.getParameter("rank").toString());
        Report report = new Report();
        report.setName(name);
        report.setType(type);
        report.setDept(dept);
        report.setTime(time);
        report.setRank(rank);
        report.setUser_id(user.getId());
        report.setResult("待审核");
        ReportDaoImpl reportDao = new ReportDaoImpl();
        reportDao.AddReport(report);
        RequestDispatcher dispatcher=
                request.getRequestDispatcher("postgraduate_index.jsp");
        dispatcher.forward(request, response);
    }
}
