package com.edu.service.assistant;

import com.edu.dao.base.DaoFactory;
import com.edu.domain.assistant.Assessment;
import com.edu.domain.common.Postgraduate;
import com.edu.domain.common.User;

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
 * Servlet implementation class assistant_result
 */
@WebServlet("/assistant_result")
public class assistant_result extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public assistant_result() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		User u=(User)request.getSession().getAttribute("userbean");
	 	   
		Postgraduate pos= DaoFactory.getInstance().getPostgraduateDao().selectPostgraduateByUserId(u.getId());
	   
		List<Assessment> list=new ArrayList<>();
	    list=DaoFactory.getInstance().getAssessmentDao().Assessment_SELECT_BY_Sno_Id(pos.getId());
		request.getSession().setAttribute("assistant_result_num",list.size());
	    for(int i=0;i<list.size();i++)
	    {
	        System.out.println(list.get(i).getSno_id()+" "+list.get(i).getTeachar_appraise()+" "+list.get(i).getAppraise_time()+" "+list.get(i).getAppraise_result());
	        request.getSession().setAttribute(String.valueOf(i)+"assistant_result_sno_id",list.get(i).getSno_id());
			request.getSession().setAttribute(String.valueOf(i)+"assistant_result_teacher_appraise",list.get(i).getTeachar_appraise());
			request.getSession().setAttribute(String.valueOf(i)+"assistant_result_appraise_time",String.valueOf(list.get(i).getAppraise_time()));
			request.getSession().setAttribute(String.valueOf(i)+"assistant_result_appraise_result",list.get(i).getAppraise_result());

	    }
	    
		String forwardUrl="assistant_result.jsp";
		RequestDispatcher dispatcher =
				request.getRequestDispatcher(forwardUrl);
				dispatcher.forward(request, response);	
		   
	    
		
	}

}
