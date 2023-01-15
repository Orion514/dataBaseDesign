package com.edu.service.assistant;

import com.edu.dao.base.DaoFactory;
import com.edu.domain.assistant.Course;
import com.edu.domain.assistant.Result;
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
 * Servlet implementation class choice_result
 */
@WebServlet("/choice_result")
public class choice_result extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public choice_result() {
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
		User u=(User)request.getSession().getAttribute("userbean");
		Postgraduate pos=DaoFactory.getInstance().getPostgraduateDao().selectPostgraduateByUserId(u.getId());
		Result re =new Result();
		re.setSno_id(pos.getId());
		ArrayList<Result> list=new ArrayList<>();
		list= DaoFactory.getInstance().getResultDao().selectResult(re);
		request.getSession().setAttribute("result_sno",pos.getId());
		request.getSession().setAttribute("result_num",list.size());
		for(int i=0;i<list.size();i++)
		{
			List<Course> li = new ArrayList<>();
			li=DaoFactory.getInstance().getCourseDao().selectCourseByCid(list.get(i).getCid());
			request.getSession().setAttribute(String.valueOf(i)+"result_num",li.size());
			for(int j=0;j<li.size();j++)
			{
				request.getSession().setAttribute(String.valueOf(i)+String.valueOf(j)+"result_cid",String.valueOf(li.get(j).getCid()));
				request.getSession().setAttribute(String.valueOf(i)+String.valueOf(j)+"result_name",String.valueOf(li.get(j).getName()));
				request.getSession().setAttribute(String.valueOf(i)+String.valueOf(j)+"result_property",String.valueOf(li.get(j).getProperty()));
				request.getSession().setAttribute(String.valueOf(i)+String.valueOf(j)+"result_teach_object",String.valueOf(li.get(j).getTeach_object()));
				request.getSession().setAttribute(String.valueOf(i)+String.valueOf(j)+"result_subject_id",String.valueOf(li.get(j).getSubject_id()));
				request.getSession().setAttribute(String.valueOf(i)+String.valueOf(j)+"result_hour",String.valueOf(li.get(j).getHour()));
			}
		}
		String forwardUrl="choice_result.jsp";
		RequestDispatcher dispatcher =
				request.getRequestDispatcher(forwardUrl);
		dispatcher.forward(request, response);
	}

}
