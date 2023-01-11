package com.edu.service.academic_exchange;

import com.edu.dao.PostgraduateDaoImpl;
import com.edu.po.Academic_Exchange;
import com.edu.dao.academic_exchange.Academic_ExchangeDaoImpl;
import com.edu.po.Postgraduate;
import com.edu.po.User;

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

@WebServlet("/Academic_Exchange_Select")
public class Academic_Exchange_Select extends HttpServlet {

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
        Academic_ExchangeDaoImpl academic_exchangeDao=new Academic_ExchangeDaoImpl();
        List<Academic_Exchange> list=academic_exchangeDao.selectAcademic_Exchange();
        boolean flag=true;
        for(Academic_Exchange l:list){
            if(l.getAudit_result()!=null&&l.getAudit_result().equals("待审核")){
                flag=false;
                break;
            }
        }
        if(!flag){
            RequestDispatcher dispatcher=request.getRequestDispatcher("academic_exchange_select_default1.jsp");
            dispatcher.forward(request, response);
        }
        String []selected_academic_exchange=request.getParameterValues("selected_academic_exchange");
        if(selected_academic_exchange==null){
            flag=false;
            RequestDispatcher dispatcher=request.getRequestDispatcher("academic_exchange_select_default2.jsp");
            dispatcher.forward(request, response);
        }
        int length= selected_academic_exchange.length;
        HttpSession session= request.getSession();
        int count=(int)session.getAttribute("academic_exchange_count");
        if(length!=count){
            flag=false;
            RequestDispatcher dispatcher=request.getRequestDispatcher("academic_exchange_select_default2.jsp");
            dispatcher.forward(request, response);
        }
        if(flag){
            User user=(User)session.getAttribute("userbean");
            int user_id= user.getId();
            PostgraduateDaoImpl pd=new PostgraduateDaoImpl();
            Postgraduate student=pd.selectPostgraduateByUserId(user_id);
            for(String s:selected_academic_exchange) {
                academic_exchangeDao.updateAcademic_Exchange1(student.getId(), Integer.parseInt(s), "待审核");
            }
            RequestDispatcher dispatcher=
                    request.getRequestDispatcher("postgraduate_index.jsp");
            dispatcher.forward(request, response);
        }
        //String s="<td><image src=\"C:\\Users\\86199\\IdeaProjects\\dataBaseDesign\\web\\image\\img1.png"+"\"width=\"100\" height=\"100\"></td>";

    }
}
