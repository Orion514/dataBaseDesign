package com.edu.service.assistant;

import com.edu.dao.base.DaoFactory;
import com.edu.domain.assistant.Audit;
import com.edu.domain.assistant.Result;

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
 * Servlet implementation class agree_chooice
 */
@WebServlet("/agree_chooice")
public class agree_chooice extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public agree_chooice() {
        super();
        // TODO Auto-generated constructor stub
    }
    
 



    //修改审核表信息
    public void AuditUpdate1(int id)
    {
        Audit au=new Audit();
        au.setId(id);
        au.setAudit_state("通过");
        DaoFactory.getInstance().getAuditDao().updateAudit(au);
        Result re =new Result();
        ArrayList<Audit> list=DaoFactory.getInstance().getAuditDao().selectAuditById(id);
        re.setSno_id(list.get(0).getSno_id());
        re.setCid(list.get(0).getCid());
        DaoFactory.getInstance().getResultDao().addResult(re);
        System.out.println("修改成功");
    }
 
    //自动更新另一个志愿
    public void AuditAutoUpdate(String sno_id)
    {
        ArrayList<Audit> list=new ArrayList<>();
        list=DaoFactory.getInstance().getAuditDao().selectAuditBySnod(sno_id);
        int flag=1;
        for(int i=0;i<list.size();i++)
        {
            System.out.println(list.get(i).getSno_id());
            if(list.get(i).getAudit_state().equals("通过")&&list.get(i).getChoice()==1)
            {
                flag=0;
                break;
            }
        }
        if(flag==0)
        {
            for(int i=0;i<list.size();i++)
            {
                if(list.get(i).getChoice()==2)
                {
                    int id=list.get(i).getId();
                    Audit au=new Audit();
                    au.setId(id);
                    au.setAudit_state("不通过");
                    DaoFactory.getInstance().getAuditDao().updateAudit(au);
                    System.out.println("修改成功");
                }
            }
        }
    }



    /*
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
		 AuditUpdate1(id);
		
		 ArrayList<Audit> list=new ArrayList<>();
	     list=DaoFactory.getInstance().getAuditDao().selectAuditById(id);
	     for(int i=0;i<list.size();i++)
	     {
	    	   //System.out.println(list.get(i).getSno_id()+"plplpl");
	    	   AuditAutoUpdate(list.get(i).getSno_id());
	     }
	     //String sno_id=list.get(0).getSno_id();
	    
		
 		}
 		
 		String list_choice2_id=request.getParameter("list_choice2_idd");
 		if(list_choice2_id!=null)
 		{
 		int id2=Integer.parseInt(list_choice2_id);
		AuditUpdate1(id2);
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
