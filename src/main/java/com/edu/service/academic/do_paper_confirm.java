package com.edu.service.academic;

import com.edu.dao.PaperDaoImpl;
import com.edu.po.Paper;
import com.edu.po.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/do_paper_confirm")
public class do_paper_confirm extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("userbean");
        String paper_name = request.getParameter("paper_name").toString();
        String status = request.getParameter("status").toString();
        String press_name = request.getParameter("press_name").toString();
        String time = request.getParameter("time").toString();
        String type = request.getParameter("type").toString();
        String lib = request.getParameter("lib").toString();
        Paper paper = new Paper();
        paper.setPaper_name(paper_name);
        paper.setStatus(status);
        paper.setPress_name(press_name);
        paper.setTime(time);
        paper.setType(type);
        paper.setLib(lib);
        paper.setUser_id(user.getId());
        paper.setResult("待审核");
        PaperDaoImpl paperDao = new PaperDaoImpl();
        paperDao.AddPaper(paper);
        RequestDispatcher dispatcher=
                request.getRequestDispatcher("postgraduate_index.jsp");
        dispatcher.forward(request, response);
    }
}
