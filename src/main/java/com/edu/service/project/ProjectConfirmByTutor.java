package com.edu.service.project;

import com.edu.dao.base.DaoFactory;
import com.edu.domain.project.Participate;
import com.edu.domain.project.Project;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ProjectConfirmByTutor", value = "/ProjectConfirmByTutor")
public class ProjectConfirmByTutor extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String pgid=request.getParameter("pgid");
        String project_id=request.getParameter("project_id");
        float funds=Float.parseFloat(request.getParameter("funds").toString());
        if(pgid.equals("")||project_id.equals("")||request.getParameter("funds").equals("")){
            response.getWriter().write("<script language=javascript>alert('提示，文本不可为空');window.location='projectconfirm.jsp'</script>");
            return;
        }

        Project project= DaoFactory.getInstance().getProjectDao().selectProjectByIdentifier(project_id);
        float surplus_funds=project.getSurplus_funds();
        project.setSurplus_funds(surplus_funds-funds);
        DaoFactory.getInstance().getProjectDao().UpdateProject(project);
        if(funds>=6.0){
            Participate participate=DaoFactory.getInstance().getParticipateDao().getParticipateByPostgraduateId(pgid);
            participate.setFunds(funds);
            DaoFactory.getInstance().getParticipateDao().UpdateParticipate(participate);
            response.getWriter().write("<script language=javascript>alert('提示，导师通过签字，完成项目认定');window.location='projectconfirm.jsp'</script>");
        }
        else{
            DaoFactory.getInstance().getParticipateDao().DeleteParticipate(pgid);
            response.getWriter().write("<script language=javascript>alert('提示，承担工作不够，不通过认定');window.location='projectconfirm.jsp'</script>");
        }
    }
}
