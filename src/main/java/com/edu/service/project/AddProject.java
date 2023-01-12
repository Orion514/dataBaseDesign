package com.edu.service.project;

import com.edu.dao.base.DaoFactory;
import com.edu.domain.project.Project;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AddProject", value = "/AddProject")
public class AddProject extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String pid=request.getParameter("pid");
        String pname=new String(request.getParameter("pname").getBytes("ISO-8859-1"),"utf-8").trim();
        String ptype=new String(request.getParameter("ptype").getBytes("ISO-8859-1"),"utf-8").trim();
        String tutor_id=request.getParameter("tutor_id");
        float pfunds=Float.parseFloat(request.getParameter("pfunds").toString());
        if (pid.equals("") || pname.equals("") || ptype.equals("") || tutor_id.equals("")||request.getParameter("pfunds").equals("")) {
            response.getWriter().write("<script language=javascript>alert('提示，文本不可为空');window.location='addproject.jsp'</script>");
            return;
        }

        int hasTutor=0; //0表示无该导师，1表示有该导师
        //....
        Project proj=new Project();
        proj.setIdentifier(pid);
        proj.setType(ptype);
        proj.setName(pname);
        proj.setTutor_id(tutor_id);
        proj.setFunds(pfunds);
        proj.setSurplus_funds(pfunds);
        DaoFactory.getInstance().getProjectDao().AddProject(proj);
        response.getWriter().write("<script language=javascript>alert('提示，添加项目成功');window.location='admin_index.jsp'</script>");


    }
}
