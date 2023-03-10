package com.edu.service.academic;

import com.edu.dao.achievement.impl.StandardDaoImpl;
import com.edu.domain.achievement.Standard;
import com.edu.domain.common.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/do_standard_confirm")
public class do_standard_confirm extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("userbean");
        String std_name = request.getParameter("std_name").toString();
        String time = request.getParameter("time").toString();
        String type = request.getParameter("type").toString();
        Standard standard = new Standard();
        standard.setStd_name(std_name);
        standard.setType(type);
        standard.setTime(time);
        standard.setUser_id(user.getId());
        standard.setResult("待审核");
        StandardDaoImpl standardDao = new StandardDaoImpl();
        standardDao.AddStandard(standard);
        RequestDispatcher dispatcher=
                request.getRequestDispatcher("postgraduate_index.jsp");
        dispatcher.forward(request, response);
    }
}
