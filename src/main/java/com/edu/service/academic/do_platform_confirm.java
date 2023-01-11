package com.edu.service.academic;

import com.edu.dao.PlatformDaoImpl;
import com.edu.dao.StandardDaoImpl;
import com.edu.po.Platform;
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

@WebServlet("/do_platform_confirm")
public class do_platform_confirm extends HttpServlet {
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
        String dept = request.getParameter("dept").toString();
        String time = request.getParameter("time").toString();
        int rank = Integer.parseInt(request.getParameter("rank").toString());
        Platform platform = new Platform();
        platform.setName(name);
        platform.setDept(dept);
        platform.setTime(time);
        platform.setRank(rank);
        platform.setUser_id(user.getId());
        platform.setResult("待审核");
        PlatformDaoImpl platformDao = new PlatformDaoImpl();
        platformDao.AddPlatform(platform);
        RequestDispatcher dispatcher=
                request.getRequestDispatcher("postgraduate_index.jsp");
        dispatcher.forward(request, response);
    }
}
