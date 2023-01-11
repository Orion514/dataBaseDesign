package com.edu.service.project;

import com.edu.dao.base.DaoFactory;
import com.edu.po.Postgraduate;
import com.edu.po.Tutor;
import com.edu.po.User;
import com.edu.po.User_Role;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CreatePostgraduateByAdmin", value = "/CreatePostgraduateByAdmin")
public class CreatePostgraduateByAdmin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        int user_id=Integer.parseInt(request.getParameter("userid"));
        String account=request.getParameter("account");
        String password=request.getParameter("password");
        String pg_id=request.getParameter("pg_id");
        String pg_name=new String(request.getParameter("pg_name").getBytes("ISO-8859-1"),"utf-8").trim();
        String pg_type=new String(request.getParameter("pg_type").getBytes("ISO-8859-1"),"utf-8").trim();
        String tutor_id=request.getParameter("tutor_id");
        if(request.getParameter("userid").equals("")||account.equals("")||password.equals("")||tutor_id.equals("")||pg_id.equals("")||pg_name.equals("")||pg_type.equals("")){
            response.getWriter().write("<script language=javascript>alert('提示，文本不可为空');window.location='CreatePostgraduate.jsp'</script>");
            return;
        }

        User user=new User();
        Postgraduate pg=new Postgraduate();
        User_Role ur=new User_Role();
        ur.setUser_id(user_id);
        ur.setRole_id(2);
        user.setId(user_id);
        user.setAccount(account);
        user.setPassword(password);
        pg.setId(pg_id);
        pg.setName(pg_name);
        pg.setIdentity(pg_type);
        pg.setTutor_id(tutor_id);
        pg.setUser_id(user_id);

        DaoFactory.getInstance().getPostgraduateDao().addPostgraduate(pg);
        DaoFactory.getInstance().getUserDao().addUser(user);
        DaoFactory.getInstance().getUser_RoleDao().addUser_Role(ur);
        response.getWriter().write("<script language=javascript>alert('提示，创建研究生成功');window.location='CreatePostgraduate.jsp'</script>");

    }
}
