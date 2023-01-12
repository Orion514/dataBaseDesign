package com.edu.dao.assistant;

import com.edu.domain.assistant.CourseTeacherView;

import java.util.List;

public interface CourseTeacherDao {
    public int selectIdByTidAndCid(String tid, String cid);
    public List<String> selectCidByTid(String tid);

    public List<CourseTeacherView> getCourseTeacherAll();

    public CourseTeacherView selectViewById(int id);

    public List<Integer> selectTeacherCourseIdbyTid(String tid);

}
