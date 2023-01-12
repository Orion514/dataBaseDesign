package com.edu.service.academic_exchange;

import com.edu.dao.academic_exchange.impl.Academic_ExchangeDaoImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/Academic_Exchange_Audit")
public class Academic_Exchange_Audit extends HttpServlet {

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
        //
        Academic_ExchangeDaoImpl academic_exchangeDao=new Academic_ExchangeDaoImpl();
        HttpSession session= request.getSession();
        List<String> audit_student_ids= (List<String>) session.getAttribute("audit_student_ids");
        for(String s:audit_student_ids) {
            String audit_result = new String(request.getParameter("audit_result" + s).getBytes("ISO-8859-1"), "utf-8").trim();
            academic_exchangeDao.updateAcademic_Exchange2(s, audit_result);
        }
        RequestDispatcher dispatcher=
                request.getRequestDispatcher("tutor_index.jsp");
        dispatcher.forward(request, response);
    }
}
