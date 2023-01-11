package com.edu.service.project;

import com.edu.dao.base.DaoFactory;
import com.edu.po.Subject_Leader;
import com.edu.po.Tutor;
import com.edu.po.User;
import com.edu.po.User_Role;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CreateSubject_LeaderByAdmin", value = "/CreateSubject_LeaderByAdmin")
public class CreateSubject_LeaderByAdmin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        int user_id=Integer.parseInt(request.getParameter("userid"));
        String account=request.getParameter("account");
        String password=request.getParameter("password");
        String subject_leader_id=request.getParameter("subject_leader_id");
        String subject_leader_name=new String(request.getParameter("subject_leader_name").getBytes("ISO-8859-1"),"utf-8").trim();
        String subject_id=request.getParameter("subject_id");
        if(request.getParameter("userid").equals("")||account.equals("")||password.equals("")||subject_leader_id.equals("")||subject_leader_name.equals("")||subject_id.equals("")){
            response.getWriter().write("<script language=javascript>alert('提示，文本不可为空');window.location='CreateSubject_Leader.jsp'</script>");
            return;
        }
        User user=new User();
        Subject_Leader subject_leader=new Subject_Leader();
        User_Role ur=new User_Role();
        ur.setUser_id(user_id);
        ur.setRole_id(3);
        user.setId(user_id);
        user.setAccount(account);
        user.setPassword(password);
        subject_leader.setId(subject_leader_id);
        subject_leader.setUser_id(user_id);
        subject_leader.setName(subject_leader_name);
        subject_leader.setSubject_id(subject_id);
        DaoFactory.getInstance().getSubject_LeaderDao().addSubject_Leader(subject_leader);
        DaoFactory.getInstance().getUserDao().addUser(user);
        DaoFactory.getInstance().getUser_RoleDao().addUser_Role(ur);
        response.getWriter().write("<script language=javascript>alert('提示，创建学科负责人成功');window.location='CreateSubject_Leader.jsp'</script>");

    }
}
