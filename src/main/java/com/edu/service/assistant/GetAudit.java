package com.edu.service.assistant;


import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.dao.base.DaoFactory;
import com.edu.domain.assistant.Audit;
import com.edu.domain.common.User;





/**
 * Servlet implementation class GetAudit
 */
@WebServlet("/GetAudit")
public class GetAudit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAudit() {
        super();
        // TODO Auto-generated constructor stub
    }

    
    //给审核表添加信息
    public void AuditAdd(String sno_id,String cid,String audit_state,int choice)
    {
        int num= DaoFactory.getInstance().getAuditDao().selectAllAudit();
        num+=1;
        Audit au=new Audit();
        au.setId(num);
        au.setSno_id(sno_id);
        au.setCid(cid);
        audit_state="待审核";
        au.setAudit_state(audit_state);
        au.setChoice(choice);
        //志愿查重
        if(AuditCheck(sno_id,choice)==true)
        {
            DaoFactory.getInstance().getAuditDao().addAudit(au);
            System.out.println("添加成功");
        }

    }


    
    
    //筛选该教师所教授课程的申请情况
    //教师登录之后，已知教师id
    //教师课程表中的授课教师id  -->查找到该教师对应的课程id  cid（不止一个）

    
    public List<String> selectCource_id(String tid)
    {
        List<String> list=new ArrayList<>();
        list=DaoFactory.getInstance().getCourseTeacherDao().selectCidByTid(tid);
        for(int i=0;i<list.size();i++)
        {
            System.out.println(list.get(i));
        }
        return list;
    }
    
    public ArrayList<Audit> selectAuditCourse(List<String>idd) {
        ArrayList<Audit> allist=new ArrayList<>();
        for (int k = 0; k < idd.size(); k++)
        {
            ArrayList<Audit> list = new ArrayList<>();
            list = DaoFactory.getInstance().getAuditDao().selectAuditByCid(idd.get(k));
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i).getId());
                if(list.get(i).getAudit_state().equals("待审核"))
                {
                allist.add(list.get(i));
                }
            }
        }
        return allist;
    }
    //筛选第一志愿
    public ArrayList<Audit> selectAuditCourse_choice1(ArrayList<Audit>list)
    {
        ArrayList<Audit>li=new ArrayList<>();
        for(int i=0;i<list.size();i++)
        {
            if(list.get(i).getChoice()==1)
            {
                li.add(list.get(i));
            }
        }
        return li;
    }

    //筛选第二志愿
    public ArrayList<Audit> selectAuditCourse_choice2(ArrayList<Audit>list)
    {
        ArrayList<Audit>li=new ArrayList<>();
        for(int i=0;i<list.size();i++)
        {
            if(list.get(i).getChoice()==2)
            {
                li.add(list.get(i));
            }
        }
        return li;
    }




    //修改审核表信息
    public void AuditUpdate1(int id)
    {
        Audit au=new Audit();
        au.setId(id);
        au.setAudit_state("通过");
        DaoFactory.getInstance().getAuditDao().updateAudit(au);
        System.out.println("修改成功");
    }
    public void AuditUpdate2(int id)
    {
        Audit au=new Audit();
        au.setId(id);
        au.setAudit_state("不通过");
        DaoFactory.getInstance().getAuditDao().updateAudit(au);
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

    //志愿查重
    public boolean AuditCheck(String sno_id,int choice)
    {
        ArrayList<Audit> list=new ArrayList<>();
        list=DaoFactory.getInstance().getAuditDao().selectAuditBySnod(sno_id);
        int flag=1;
        for(int i=0;i<list.size();i++)
        {
            if(choice==list.get(i).getChoice())
            {
                System.out.println("已经有该志愿，请重新选择志愿");
                return false;
            }
        }
        return true;
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
		// TODO Auto-generated method stub
 		request.setCharacterEncoding("UTF-8");
 		response.setCharacterEncoding("UTF-8");
 		response.setContentType("text/html;charset=UTF-8");
 		
 	   User u=(User)request.getSession().getAttribute("userbean");
 	   
      
       String tid=DaoFactory.getInstance().getTeacherDao().selectTidByUId(u.getId());
       
       List<String> list=selectCource_id(tid);
       //根据课程号，获取审核信息
       ArrayList<Audit> list2=selectAuditCourse(list);
       //获取第一志愿审核信息
       ArrayList<Audit> list_choice1=selectAuditCourse_choice1(list2);
       //获取第二志愿审核信息
       ArrayList<Audit> list_choice2=selectAuditCourse_choice2(list2);
	   request.getSession().setAttribute("list_choice1_num", list_choice1.size());
	   request.getSession().setAttribute("list_choice2_num", list_choice2.size());

       for(int i=0;i<list_choice1.size();i++)
       {
    	   request.getSession().setAttribute(String.valueOf(i)+"list_choice1_id", String.valueOf(list_choice1.get(i).getId()));
    	   request.getSession().setAttribute(String.valueOf(i)+"list_choice1_sno_id", list_choice1.get(i).getSno_id());
    	   request.getSession().setAttribute(String.valueOf(i)+"list_choice1_cid", list_choice1.get(i).getCid());
    	   request.getSession().setAttribute(String.valueOf(i)+"list_choice1_audit_state", list_choice1.get(i).getAudit_state());
    	   request.getSession().setAttribute(String.valueOf(i)+"list_choice1_choice", String.valueOf(list_choice1.get(i).getChoice()));

       }
       for(int i=0;i<list_choice2.size();i++)
       {
    	   request.getSession().setAttribute(String.valueOf(i)+"list_choice2_id", String.valueOf(list_choice2.get(i).getId()));
    	   request.getSession().setAttribute(String.valueOf(i)+"list_choice2_sno_id", list_choice2.get(i).getSno_id());
    	   request.getSession().setAttribute(String.valueOf(i)+"list_choice2_cid", list_choice2.get(i).getCid());
    	   request.getSession().setAttribute(String.valueOf(i)+"list_choice2_audit_state", list_choice2.get(i).getAudit_state());
    	   request.getSession().setAttribute(String.valueOf(i)+"list_choice2_choice", String.valueOf(list_choice2.get(i).getChoice()));
       }
       
       
 		    
		String forwardUrl="assistance_tea_1.jsp";
		RequestDispatcher dispatcher =
				request.getRequestDispatcher(forwardUrl);
				dispatcher.forward(request, response);	
	}

}
