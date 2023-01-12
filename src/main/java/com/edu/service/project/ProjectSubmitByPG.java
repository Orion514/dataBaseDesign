package com.edu.service.project;

import com.edu.dao.base.DaoFactory;
import com.edu.domain.project.Participate;
import com.edu.domain.common.Postgraduate;
import com.edu.domain.common.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ProjectSubmitByPG", value = "/ProjectSubmitByPG")
public class ProjectSubmitByPG extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String time=new String(request.getParameter("time").getBytes("ISO-8859-1"),"utf-8").trim();
        String undertake=new String(request.getParameter("undertake").getBytes("ISO-8859-1"),"utf-8").trim();
        if(time.equals("")||undertake.equals("")) {
            response.getWriter().write("<script language=javascript>alert('提示，文本不可为空');window.location='projectsubmit.jsp'</script>");
            return;
        }
        User user=(User)request.getSession().getAttribute("userbean");
        int user_id=user.getId();
        Postgraduate postgraduate= DaoFactory.getInstance().getPostgraduateDao().selectPostgraduateByUserId(user_id);
        Participate participate=DaoFactory.getInstance().getParticipateDao().getParticipateByPostgraduateId(postgraduate.getId());
        participate.setTime(time);
        participate.setUndertake(undertake);
        DaoFactory.getInstance().getParticipateDao().UpdateParticipate(participate);
        response.getWriter().write("<script language=javascript>alert('提示，填写认定表成功，等待导师签字认定获得经费');window.location='postgraduate_index.jsp'</script>");


    }
}
