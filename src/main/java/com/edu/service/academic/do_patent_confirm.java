package com.edu.service.academic;

import com.edu.dao.achievement.impl.PatentDaoImpl;
import com.edu.domain.achievement.Patent;
import com.edu.po.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/do_patent_confirm")
public class do_patent_confirm extends HttpServlet {
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
        String type = request.getParameter("type").toString();
        String patent_no = request.getParameter("patent_no").toString();
        String time = request.getParameter("time").toString();
        String status = request.getParameter("status").toString();
        int rank = Integer.parseInt(request.getParameter("rank").toString());
        Patent patent = new Patent();
        patent.setName(name);
        patent.setType(type);
        patent.setPatent_no(patent_no);
        patent.setTime(time);
        patent.setStatus(status);
        patent.setRank(rank);
        patent.setUser_id(user.getId());
        patent.setResult("待审核");
        PatentDaoImpl patentDao = new PatentDaoImpl();
        patentDao.AddPatent(patent);
        RequestDispatcher dispatcher=
                request.getRequestDispatcher("postgraduate_index.jsp");
        dispatcher.forward(request, response);
    }
}
