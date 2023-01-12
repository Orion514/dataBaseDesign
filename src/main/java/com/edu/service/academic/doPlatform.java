package com.edu.service.academic;

import com.edu.dao.achievement.impl.PlatformDaoImpl;
import com.edu.domain.achievement.Platform;
import com.edu.domain.common.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/doPlatform")
public class doPlatform extends HttpServlet {
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
        Platform platform = new Platform();
        platform.setId(id);
        platform.setResult(result);
        PlatformDaoImpl platformDao = new PlatformDaoImpl();
        platformDao.updateResultById(platform);
        RequestDispatcher dispatcher=
                request.getRequestDispatcher("tutor_confirm.jsp");
        dispatcher.forward(request, response);
    }
}
