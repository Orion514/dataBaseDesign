package com.edu.service.academic;

import com.edu.dao.base.DaoFactory;
import com.edu.po.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "GetLogin", value = "/GetLogin")
public class GetLogin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String account=request.getParameter("account");
        String password=request.getParameter("password");
        User u= DaoFactory.getInstance().getUserDao().selectUserByAccount(account);
        String forwardUrl=null;
        if(u != null&&u.getAccount().equals(account)&&u.getPassword().equals(password)){
            HttpSession session=request.getSession();
            session.setAttribute("userbean", u);	//存当前用户
            int role_id=DaoFactory.getInstance().getUser_RoleDao().selectRoleIdByUserId(u.getId());
            if(role_id==1){
                forwardUrl="admin_index.jsp";
            }
            else if(role_id==2 || role_id == 6){
                forwardUrl="postgraduate_index.jsp";
            }
            else if(role_id==3){
                forwardUrl="xxx";
            }
            else if(role_id==4){
                forwardUrl="xxx";
            }
            else if(role_id==5){
                forwardUrl="tutor_index.jsp";
            }
        }
        else {
            response.getWriter().write("<script language=javascript>alert('提示，账号或密码错误');window.location='login.jsp'</script>");
            return;
        }

        RequestDispatcher dispatcher=
                request.getRequestDispatcher(forwardUrl);
        dispatcher.forward(request, response);
    }
}
