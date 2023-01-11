package com.edu.service.academic;

import com.edu.dao.achievement.impl.PrizeDaoImpl;
import com.edu.domain.achievement.Prize;
import com.edu.po.User;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
@WebServlet("/do_prize_confirm")
public class do_prize_confirm extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("userbean");
        String prize_name = request.getParameter("prize_name").toString();
        String time = request.getParameter("time").toString();
        String type = request.getParameter("type").toString();
        String prize = request.getParameter("prize").toString();
        int rank = Integer.parseInt(request.getParameter("rank").toString());
        Prize p = new Prize();
        p.setName(prize_name);
        p.setType(type);
        p.setPrize(prize);
        p.setRank(rank);
        p.setTime(time);
        p.setUser_id(user.getId());
        PrizeDaoImpl prizeDao = new PrizeDaoImpl();
        prizeDao.AddPrize(p);
        RequestDispatcher dispatcher=
                request.getRequestDispatcher("postgraduate_index.jsp");
        dispatcher.forward(request, response);
    }
}
