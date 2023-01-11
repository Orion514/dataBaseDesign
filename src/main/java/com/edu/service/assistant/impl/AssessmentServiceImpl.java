package com.edu.service.assistant.impl;

import com.edu.dao.assistant.*;
import com.edu.dao.base.DaoFactory;
import com.edu.domain.assistant.Assessment;
import com.edu.domain.assistant.vo.AssessmentView;
import com.edu.service.assistant.AssessmentService;

import java.sql.Date;

/**
 * assessmentServiceImpl : 中文
 */
public class AssessmentServiceImpl implements AssessmentService {
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
}
