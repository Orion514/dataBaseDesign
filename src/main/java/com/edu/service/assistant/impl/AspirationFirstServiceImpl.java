package com.edu.service.assistant.impl;

import com.edu.dao.assistant.*;
import com.edu.dao.base.DaoFactory;
import com.edu.domain.assistant.Assessment;
import com.edu.domain.assistant.vo.AssessmentView;
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

        AssessmentView assessmentView = assessmentDao.selectById(Integer.parseInt(selectId));
        Assessment assessment = new Assessment();
        assessment.setSno_id(assessmentView.getStudent_id());
        assessment.setCourse_teacher_id(assessmentView.getCourse_teacher_id());
        assessment.setWork_statement(assessmentView.getWork_statement());
        assessment.setStatement_time(assessmentView.getStatement_time());
        assessment.setTeachar_appraise(assessmentView.getAppraise());
        assessment.setAppraise_time(assessmentView.getAppraise_time());
        assessment.setAppraise_result(assessmentView.getAppraise_result());

        assessmentDao.addOne(assessment);

        String forwardURL = "assistant_stu_2.jsp";
        request.getRequestDispatcher(forwardURL).forward(request,response);
    }
}
