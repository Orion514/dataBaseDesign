package com.edu.dao.assistant;

public interface CourseDao {

    public String selectCidByNamePrObjAndSub(String name, String property, String teach_object , String sub_id);
}
