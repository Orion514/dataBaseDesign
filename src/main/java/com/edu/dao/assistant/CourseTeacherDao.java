package com.edu.dao.assistant;

import java.util.List;

public interface CourseTeacherDao {
    public int selectIdByTidAndCid(String tid, String cid);
    public List<String> selectCidByTid(String tid);
}
