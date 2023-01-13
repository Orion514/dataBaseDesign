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
 * AssessmentServiceImpl : 助教评定表提交实现类
 */
@WebServlet("/assistant_stu_assessment")
public class AssessmentServiceImpl extends HttpServlet implements AssessmentService {
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

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");

        AssessmentView assessmentView = new AssessmentView();
        String stu_id = request.getParameter("stu_id");
        String stu_name = request.getParameter("stu_name");
        String stu_sub_name = request.getParameter("stu_subject_name");
    //        String stu_sub_name = studentDao.getSubNameBySno(stu_id);
        String course_name = request.getParameter("course_name");
        String course_property = request.getParameter("course_property");
        String course_object = request.getParameter("course_object");
        String teacher_name = request.getParameter("teacher_name");
        String teach_student_num = request.getParameter("teach_student_num");
        String teach_time = request.getParameter("teach_time");
        String work_statement = request.getParameter("work_statement");
        java.util.Date d = new java.util.Date();
        Date sqlD = new Date(d.getTime());

        int teach_num = 0;
        try {
            teach_num = Integer.valueOf(teach_student_num);
        } catch (Exception e){
            response.getWriter().write("<script language=javascript>alert('提示，填写错误，授课人数需为正整数');window.location='assistant_stu_assessment.jsp'</script>");
            return;
        }

        assessmentView.setStudent_id(stu_id);
        assessmentView.setStudent_name(stu_name);
        assessmentView.setSubject_name(stu_sub_name);
        assessmentView.setCourse_name(course_name);
        assessmentView.setCourse_property(course_property);
        assessmentView.setCourse_object(course_object);
        assessmentView.setTeacher_name(teacher_name);
        assessmentView.setCourse_student_num(teach_num);
        assessmentView.setTeach_time(teach_time);
        assessmentView.setWork_statement(work_statement);
        assessmentView.setStatement_time(sqlD);

        int res = addOne(assessmentView);
        if(res != 1){
            response.getWriter().write("<script language=javascript>alert('提示，填写错误，后台没有相关记录，请检查');window.location='assistant_stu_assessment.jsp'</script>");
        }else{
            response.getWriter().write("<script language=javascript>alert('提交成功');window.location='assistant_stu_assessment.jsp'</script>");
        }
    }
}
