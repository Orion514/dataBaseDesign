package com.edu.dao.assistant;

/**
 * TeacherDao : 教师表DAO
 */
public interface TeacherDao {
    public String selectTidByName(String name);
    public String selectTidByUId(int user_id);

}
