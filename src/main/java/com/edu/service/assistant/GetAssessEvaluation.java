package com.edu.service.assistant;

import com.edu.dao.base.DaoFactory;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class GetAssessEvaluation
 */
@WebServlet("/GetAssessEvaluation")
public class GetAssessEvaluation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAssessEvaluation() {
        super();
        // TODO Auto-generated constructor stub
    }

    public java.sql.Date strToDate(String stringDate) throws ParseException
    {

        SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("string:"+stringDate);

        Date stDate=sdf.parse(stringDate);                 //这里的Date是java.util.Date这个包里的
        System.out.println("util.Date:"+stDate);

        java.sql.Date startDate=new java.sql.Date(stDate.getTime());
        System.out.println("sql.Date:"+startDate);
        return startDate;
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
		
		request.setCharacterEncoding("UTF-8");
 		response.setCharacterEncoding("UTF-8");
 		response.setContentType("text/html;charset=UTF-8");
 		
    	String assess_sno_id=(String)request.getSession().getAttribute("assess_sno_id");
    	String assess_course_teacher_id=(String)request.getSession().getAttribute("assess_course_teacher_id");
    	
    	
		String teacher_appraise=request.getParameter("teacher_appraise");
		String appraise_time=request.getParameter("appraise_time");
		String appraise_result=request.getParameter("appraise_result");

	    try {
			DaoFactory.getInstance().getAssessmentDao().updateBy_Course_Teacher_Sno_Id(teacher_appraise, strToDate(appraise_time),appraise_result,assess_sno_id,Integer.parseInt(assess_course_teacher_id));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	    String forwardUrl="Assessment.jsp";
		RequestDispatcher dispatcher =
				request.getRequestDispatcher(forwardUrl);
				dispatcher.forward(request, response);	

 		
 		
 		
	}

}
