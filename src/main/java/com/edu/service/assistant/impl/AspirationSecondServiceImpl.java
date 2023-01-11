package com.edu.service.assistant.impl;

import com.edu.dao.assistant.AssessmentDao;
import com.edu.dao.assistant.AuditDao;
import com.edu.dao.assistant.CourseDao;
import com.edu.dao.base.DaoFactory;
import com.edu.domain.assistant.Assessment;
import com.edu.domain.assistant.Audit;
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
    AuditDao auditDao = DaoFactory.getInstance().getAuditDao();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String selectId = request.getParameter("selectId");

        AssessmentView assessmentView = assessmentDao.selectById(Integer.parseInt(selectId));
        Audit audit = new Audit();
        audit.setId(auditDao.selectAllAudit() + 1);
        audit.setSno_id(assessmentView.getStudent_id());
        audit.setCid(assessmentView.getCourse_id());
        audit.setAudit_state("待审核");
        audit.setChoice(2);

        auditDao.addAudit(audit);

        String forwardURL = "postgraduate_index.jsp";
        request.getRequestDispatcher(forwardURL).forward(request,response);
    }
}
