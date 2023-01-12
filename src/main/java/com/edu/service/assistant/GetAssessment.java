package com.edu.service.assistant;

import com.edu.dao.base.DaoFactory;
import com.edu.domain.assistant.Assessment;
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
 * Servlet implementation class GetAssessment
 */
@WebServlet("/GetAssessment")
public class GetAssessment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAssessment() {
        super();
        // TODO Auto-generated constructor stub
    }

    //根据教师号找到教师课程表id
    public List<Integer> selectTeachCourse_id(String tid)
    {

        List<Integer> list=new ArrayList<>();
        list= DaoFactory.getInstance().getCourseTeacherDao().selectTeacherCourseIdbyTid(tid);
        return list;
    }
    
    
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request,response);
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
 		
 		  //根据教师号获取教师课程表id
        //String tid="T1234567";
 		User u=(User)request.getSession().getAttribute("userbean");
        //根据教师号获取该教师对应的课程号
        String tid=DaoFactory.getInstance().getTeacherDao().selectTidByUId(u.getId());
        List<Integer> list=selectTeachCourse_id(tid);
	    List<Assessment> alli=new ArrayList<>();
       for(int i=0;i<list.size();i++)
       {
    	    List<Assessment> li=new ArrayList<>();
            li=DaoFactory.getInstance().getAssessmentDao().selectBy_Course_Teacher_Id(list.get(i));
            for(int j=0;j<li.size();j++)
            {
            	if(li.get(j).getAppraise_result()==null)
            	{
            	alli.add(li.get(j));
            	}
            }
       }
//       System.out.println(alli.get(0).getSno_id());
//       System.out.println(alli.get(0).getCourse_teacher_id());
//       System.out.println(alli.get(0).getStatement_time());
//       System.out.println(alli.get(0).getWork_statement());
//       System.out.println(alli.get(0).getTeachar_appraise());
//       System.out.println(alli.get(0).getAppraise_time());
//       System.out.println(alli.get(0).getAppraise_result());
       
	   request.getSession().setAttribute("assess_num", alli.size());
	   for(int i=0;i<alli.size();i++)
	   {
    	   request.getSession().setAttribute(String.valueOf(i)+"assess_sno_id", String.valueOf(alli.get(i).getSno_id()));
    	   request.getSession().setAttribute(String.valueOf(i)+"assess_course_teacher_id", String.valueOf(alli.get(i).getCourse_teacher_id()));
    	   request.getSession().setAttribute(String.valueOf(i)+"assess_work_statement", String.valueOf(alli.get(i).getWork_statement()));
    	   request.getSession().setAttribute(String.valueOf(i)+"assess_statement_time", String.valueOf(alli.get(i).getStatement_time()));

	   }
	    
		String forwardUrl="assess.jsp";
		RequestDispatcher dispatcher =
				request.getRequestDispatcher(forwardUrl);
				dispatcher.forward(request, response);	
        
        
 
		
		
	}

}
