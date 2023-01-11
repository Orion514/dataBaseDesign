package com.edu.service.project;

import com.edu.dao.base.DaoFactory;
import com.edu.po.Tutor;
import com.edu.po.User;
import com.edu.po.User_Role;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CreateTutorByAdmin", value = "/CreateTutorByAdmin")
public class CreateTutorByAdmin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        int user_id=Integer.parseInt(request.getParameter("userid"));
        String account=request.getParameter("account");
        String password=request.getParameter("password");
        String tutor_id=request.getParameter("tutor_id");
        String tutor_name=new String(request.getParameter("tutor_name").getBytes("ISO-8859-1"),"utf-8").trim();
        String sub_id=request.getParameter("sub_id");
        if(request.getParameter("userid").equals("")||account.equals("")||password.equals("")||tutor_id.equals("")||tutor_name.equals("")||sub_id.equals("")){
            response.getWriter().write("<script language=javascript>alert('提示，文本不可为空');window.location='CreateTutor.jsp'</script>");
            return;
        }
        User user=new User();
        Tutor tutor=new Tutor();
        User_Role ur=new User_Role();
        ur.setUser_id(user_id);
        ur.setRole_id(5);
        user.setId(user_id);
        user.setAccount(account);
        user.setPassword(password);
        tutor.setId(tutor_id);
        tutor.setUser_id(user_id);
        tutor.setName(tutor_name);
        tutor.setSubject_id(sub_id);
        DaoFactory.getInstance().getTutorDao().addTutor(tutor);
        DaoFactory.getInstance().getUserDao().addUser(user);
        DaoFactory.getInstance().getUser_RoleDao().addUser_Role(ur);
        response.getWriter().write("<script language=javascript>alert('提示，创建导师成功');window.location='CreateTutor.jsp'</script>");

    }
}
