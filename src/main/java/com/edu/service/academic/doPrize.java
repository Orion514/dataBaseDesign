package com.edu.service.academic;

import com.edu.dao.achievement.impl.PrizeDaoImpl;
import com.edu.domain.achievement.Prize;
import com.edu.domain.common.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/doPrize")
public class doPrize extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("userbean");
        String result = request.getParameter("result").toString();
        int id = Integer.parseInt(request.getParameter("id").toString());
        Prize prize = new Prize();
        prize.setId(id);
        prize.setResult(result);
        PrizeDaoImpl prizeDao = new PrizeDaoImpl();
        prizeDao.updateResultById(prize);
        RequestDispatcher dispatcher=
                request.getRequestDispatcher("tutor_confirm.jsp");
        dispatcher.forward(request, response);
    }
}
