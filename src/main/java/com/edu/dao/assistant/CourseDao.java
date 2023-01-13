package com.edu.dao.assistant;

import com.edu.domain.assistant.Course;

import java.util.ArrayList;

public interface CourseDao {

    public String selectCidByNamePrObjAndSub(String name, String property, String teach_object , String sub_id);
    public ArrayList<Course> selectCourseByCid(String cid);

}
