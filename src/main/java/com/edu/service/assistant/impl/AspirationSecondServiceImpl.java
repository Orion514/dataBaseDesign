package com.edu.service.assistant.impl;

import com.edu.dao.assistant.*;
import com.edu.dao.base.DaoFactory;
import com.edu.dao.common.impl.PostgraduateDaoImpl;
import com.edu.domain.assistant.Assessment;
import com.edu.domain.assistant.Audit;
import com.edu.domain.assistant.CourseTeacherView;
import com.edu.domain.assistant.vo.AssessmentView;
import com.edu.domain.common.Postgraduate;
import com.edu.domain.common.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * AspirationSecondServiceImpl : 第二志愿
 */
@WebServlet("/assistant_stu_2")
public class AspirationSecondServiceImpl extends HttpServlet {
    CourseTeacherDao courseTeacherDao = DaoFactory.getInstance().getCourseTeacherDao();
    TeacherDao teacherDao = DaoFactory.getInstance().getTeacherDao();
    CourseDao courseDao = DaoFactory.getInstance().getCourseDao();
    StudentDao studentDao = DaoFactory.getInstance().getStudentDao();

    AuditDao auditDao = DaoFactory.getInstance().getAuditDao();

    AssessmentDao assessmentDao = DaoFactory.getInstance().getAssessmentDao();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String selectId = request.getParameter("selectId");

        CourseTeacherView courseTeacherView = courseTeacherDao.selectViewById(Integer.parseInt(selectId));

        // 得到当前研究生的学号
        User user=(User)request.getSession().getAttribute("userbean");
        int user_id=user.getId();
        PostgraduateDaoImpl pd=new PostgraduateDaoImpl();
        Postgraduate student=pd.selectPostgraduateByUserId(user_id);
        String student_id=student.getId();


        // AssessmentView assessmentView = assessmentDao.selectById(Integer.parseInt(selectId));

        Audit audit = new Audit();
        audit.setId(auditDao.selectAllAudit() + 1);
        audit.setSno_id(student_id);
        audit.setCid(courseTeacherView.getCourse_id());
        audit.setAudit_state("待审核");
        audit.setChoice(2);

        auditDao.addAudit(audit);

        String forwardURL = "postgraduate_index.jsp";
        request.getRequestDispatcher(forwardURL).forward(request,response);
    }
}
