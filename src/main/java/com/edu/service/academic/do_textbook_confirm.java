package com.edu.service.academic;

import com.edu.dao.achievement.impl.TextbookDaoImpl;
import com.edu.domain.achievement.Textbook;
import com.edu.domain.common.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/do_textbook_confirm")
public class do_textbook_confirm extends HttpServlet {
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
        String time = request.getParameter("time").toString();
        String press = request.getParameter("press").toString();
        int point = Integer.parseInt(request.getParameter("point").toString());
        Textbook textbook = new Textbook();
        textbook.setName(name);
        textbook.setPress(press);
        textbook.setTime(time);
        textbook.setPoint(point);
        textbook.setUser_id(user.getId());
        textbook.setResult("待审核");
        TextbookDaoImpl textbookDao = new TextbookDaoImpl();
        textbookDao.AddTextbook(textbook);
        RequestDispatcher dispatcher=
                request.getRequestDispatcher("postgraduate_index.jsp");
        dispatcher.forward(request, response);
    }
}
