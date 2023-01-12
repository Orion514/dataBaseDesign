package com.edu.service.assistant;

import com.edu.dao.base.DaoFactory;
import com.edu.domain.assistant.Audit;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class disagree_chooice
 */
@WebServlet("/disagree_chooice")
public class disagree_chooice extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public disagree_chooice() {
        super();
        // TODO Auto-generated constructor stub
    }



    //修改审核表信息
    public void AuditUpdate2(int id)
    {
        Audit au=new Audit();
        au.setId(id);
        au.setAudit_state("不通过");
        DaoFactory.getInstance().getAuditDao().updateAudit(au);
        System.out.println("修改成功");
    }

   
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("UTF-8");
 		response.setCharacterEncoding("UTF-8");
 		
 		String list_choice1_id=request.getParameter("list_choice1_idd");
 		if(list_choice1_id!=null)
 		{
 		int id=Integer.parseInt(list_choice1_id);
		AuditUpdate2(id);
 		}
		
		String list_choice2_id=request.getParameter("list_choice2_idd");
		if(list_choice2_id!=null)
		{
 		int id2=Integer.parseInt(list_choice2_id);
		AuditUpdate2(id2);
		}
		
		String forwardUrl="Audit.jsp";
		RequestDispatcher dispatcher =
					request.getRequestDispatcher(forwardUrl);
					dispatcher.forward(request, response);	
	       
	 		    
			
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
