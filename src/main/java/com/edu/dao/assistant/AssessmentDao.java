package com.edu.dao.assistant;

import com.edu.domain.assistant.Assessment;
import com.edu.domain.assistant.vo.AssessmentView;

import java.util.Date;
import java.util.List;

public interface AssessmentDao {
    public int addOne(Assessment assessment);

    // 根据学号选出所有的评定表视图
    public List<AssessmentView> selectBySno(String sno);

    // 根据学号选出评定表视图
    public AssessmentView selectById(int id);

    //根据课程教师id选出评定表
    List<Assessment> selectBy_Course_Teacher_Id(int course_teacher_id);

    //更新评定表信息
    public void updateBy_Course_Teacher_Sno_Id(String teacher_appraise, Date appraise_time, String appraise_result, String sno_id, int course_teacher_id);

    //根据学号选出评定表
    public List<Assessment> Assessment_SELECT_BY_Sno_Id(String sno_id);

    //根据学号，课程号选出评定表
    public List<AssessmentView> selectBySnoCID(String sno, String course_id);

}
