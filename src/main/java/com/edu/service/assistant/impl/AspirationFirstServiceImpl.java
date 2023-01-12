package com.edu.service.assistant.impl;

import com.edu.dao.assistant.*;
import com.edu.dao.base.Dao;
import com.edu.dao.base.DaoFactory;
import com.edu.dao.common.impl.PostgraduateDaoImpl;
import com.edu.domain.assistant.Assessment;
import com.edu.domain.assistant.Audit;
import com.edu.domain.assistant.CourseTeacherView;
import com.edu.domain.assistant.vo.AssessmentView;
import com.edu.domain.common.Postgraduate;
import com.edu.domain.common.User;
import com.edu.service.assistant.AssessmentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

/**
 * AspirationFirstServiceImpl : 第一志愿
 */


@WebServlet("/assistant_stu_1")
public class AspirationFirstServiceImpl extends HttpServlet implements AssessmentService {
    CourseTeacherDao courseTeacherDao = DaoFactory.getInstance().getCourseTeacherDao();
    TeacherDao teacherDao = DaoFactory.getInstance().getTeacherDao();
    CourseDao courseDao = DaoFactory.getInstance().getCourseDao();
    StudentDao studentDao = DaoFactory.getInstance().getStudentDao();

    AuditDao auditDao = DaoFactory.getInstance().getAuditDao();

    AssessmentDao assessmentDao = DaoFactory.getInstance().getAssessmentDao();


    @Override
    public int addOne(AssessmentView assessmentView) {
        // 找到课程教师表ID
         String tid = teacherDao.selectTidByName(assessmentView.getTeacher_name());
         String subject_id = studentDao.getSubIdBySno(assessmentView.getStudent_id());
         String cid = courseDao.selectCidByNamePrObjAndSub(assessmentView.getCourse_name(),assessmentView.getCourse_property(),assessmentView.getCourse_object(),subject_id);
         int ctid = courseTeacherDao.selectIdByTidAndCid(tid,cid);

         java.util.Date d = new java.util.Date();
         Date sqlD = new Date(d.getTime());

         Assessment assessment = new Assessment(assessmentView.getStudent_id(),ctid,assessmentView.getWork_statement(),sqlD,null,null,null);

         return assessmentDao.addOne(assessment);
    }


    /**
     * 处理学生志愿1
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
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


        Audit audit = new Audit();
        audit.setId(auditDao.selectAllAudit() + 1);
        audit.setSno_id(student_id);
        audit.setCid(courseTeacherView.getCourse_id());
        audit.setAudit_state("待审核");
        audit.setChoice(1);

        auditDao.addAudit(audit);

        String forwardURL = "assistant_stu_2.jsp";
        request.getRequestDispatcher(forwardURL).forward(request,response);
    }
}
