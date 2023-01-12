package com.edu.service.academic_exchange;

import com.edu.dao.common.impl.PostgraduateDaoImpl;
import com.edu.dao.base.DaoFactory;
import com.edu.domain.academic.Academic_Exchange;
import com.edu.dao.academic_exchange.impl.Academic_ExchangeDaoImpl;
import com.edu.domain.common.Postgraduate;
import com.edu.domain.common.Subject_Leader;
import com.edu.domain.common.Tutor;
import com.edu.domain.common.User;

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
@WebServlet("/Academic_Exchange_Add")
public class Academic_Exchange_Add extends HttpServlet {

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
        String activity_name=new String(request.getParameter("activity_name").getBytes("ISO-8859-1"),"utf-8").trim();
        String location=new String(request.getParameter("location").getBytes("ISO-8859-1"),"utf-8").trim();
        String time=new String(request.getParameter("time").getBytes("ISO-8859-1"),"utf-8").trim();
        String report_name=new String(request.getParameter("report_name").getBytes("ISO-8859-1"),"utf-8").trim();
        String image=new String(request.getParameter("image").getBytes("ISO-8859-1"),"utf-8").trim();
        String notes=new String(request.getParameter("notes").getBytes("ISO-8859-1"),"utf-8").trim();
        HttpSession session=request.getSession();
        User user=(User)session.getAttribute("userbean");
        int user_id= user.getId();
        PostgraduateDaoImpl pd=new PostgraduateDaoImpl();
        Postgraduate student=pd.selectPostgraduateByUserId(user_id);
        String student_id=student.getId();
        Academic_Exchange academic_exchange=new Academic_Exchange();
        academic_exchange.setStudent_id(student_id);
        academic_exchange.setActivity_name(activity_name);
        academic_exchange.setLocation(location);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String strtime=time.split("T")[0]+" "+time.split("T")[1];
        LocalDateTime localdatetime = LocalDateTime.parse(strtime, fmt);
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zdt = localdatetime.atZone(zoneId);
        Date date = Date.from(zdt.toInstant());
        academic_exchange.setTime(date);
        academic_exchange.setReport_name(report_name);
        academic_exchange.setImage(image);
        academic_exchange.setNotes(notes);
        Tutor tutor= DaoFactory.getInstance().getTutorDao().selectTutorById(student.getTutor_id());
        String subject_id=tutor.getSubject_id();
        Subject_Leader subject_leader=DaoFactory.getInstance().getSubject_LeaderDao().SelectSubject_LeaderBySubject_Id(subject_id);
        academic_exchange.setSubject_leader_id(subject_leader.getId());
        Academic_ExchangeDaoImpl academic_exchangeDao=new Academic_ExchangeDaoImpl();
        academic_exchangeDao.addAcademic_Exchange(academic_exchange);
        RequestDispatcher dispatcher=
                request.getRequestDispatcher("postgraduate_index.jsp");
        dispatcher.forward(request, response);
    }
}
