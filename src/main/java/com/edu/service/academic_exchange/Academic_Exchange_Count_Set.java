package com.edu.service.academic_exchange;

import com.edu.dao.PostgraduateDaoImpl;
import com.edu.dao.base.DaoFactory;
import com.edu.po.Academic_Exchange;
import com.edu.dao.academic_exchange.Academic_ExchangeDaoImpl;
import com.edu.po.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
@WebServlet("/Academic_Exchange_Count_Set")
public class Academic_Exchange_Count_Set extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
        out.println("<HTML>");
        out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
        out.println("  <BODY>");
        out.print("    This is ");
        out.print(this.getClass());
        out.println(", using the GET method");
        out.println("  </BODY>");
        out.println("</HTML>");
        out.flush();
        out.close();
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        String stracademic_exchange_count=request.getParameter("academic_exchange_count");
        int academic_exchange_count=Integer.parseInt(stracademic_exchange_count);
        HttpSession session=request.getSession();
        User user=(User)session.getAttribute("userbean");
        int user_id= user.getId();
        Subject_Leader subject_leader=DaoFactory.getInstance().getSubject_LeaderDao().SelectSubject_LeaderByUserId(user_id);
        DaoFactory.getInstance().getSubjectDao().updateSubjectBysubject_Id2(academic_exchange_count, subject_leader.getSubject_id());
        RequestDispatcher dispatcher=
                request.getRequestDispatcher("subject_leader_index.jsp");
        dispatcher.forward(request, response);
    }
}
