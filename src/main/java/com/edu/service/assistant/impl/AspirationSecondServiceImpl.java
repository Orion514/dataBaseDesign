package com.edu.service.assistant.impl;

import com.edu.dao.assistant.AssessmentDao;
import com.edu.dao.assistant.CourseDao;
import com.edu.dao.base.DaoFactory;
import com.edu.domain.assistant.Assessment;
import com.edu.domain.assistant.vo.AssessmentView;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * AspirationFirstServiceImpl : 第二志愿
 */
@WebServlet("/assistant_stu_2")
public class AspirationSecondServiceImpl extends HttpServlet {
    AssessmentDao assessmentDao = DaoFactory.getInstance().getAssessmentDao();

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

        String forwardURL = "postgraduate_index.jsp";
        request.getRequestDispatcher(forwardURL).forward(request,response);
    }
}
