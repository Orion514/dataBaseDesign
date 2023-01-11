package com.edu.service.project;

import com.edu.dao.base.DaoFactory;
import com.edu.po.Participate;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AddParticipate", value = "/AddParticipate")
public class AddParticipate extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String pgid=request.getParameter("pgid");
        String project_id=request.getParameter("project_id");
        if(pgid.equals("")||project_id.equals("")){
            response.getWriter().write("<script language=javascript>alert('提示，文本不可为空');window.location='projectdistribution.jsp'</script>");
            return;
        }

        //有该学号
        //...
        //有该项目编号
        //...

        Participate participate=new Participate();
        participate.setPostgraduate_id(pgid);
        participate.setProject_id(project_id);
        DaoFactory.getInstance().getParticipateDao().AddParticipate(participate);
        response.getWriter().write("<script language=javascript>alert('提示，成功指派该研究生参与项目');window.location='projectdistribution.jsp'</script>");
    }
}
