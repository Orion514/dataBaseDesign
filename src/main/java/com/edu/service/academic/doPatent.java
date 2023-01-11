package com.edu.service.academic;

import com.edu.dao.PatentDaoImpl;
import com.edu.dao.StandardDaoImpl;
import com.edu.po.Patent;
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

@WebServlet("/doPatent")
public class doPatent extends HttpServlet {
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
        Patent patent = new Patent();
        patent.setId(id);
        patent.setResult(result);
        PatentDaoImpl patentDao = new PatentDaoImpl();
        patentDao.updateResultById(patent);
        RequestDispatcher dispatcher=
                request.getRequestDispatcher("tutor_confirm.jsp");
        dispatcher.forward(request, response);
    }
}
