package com.edu.dao.assistant;

import com.edu.domain.assistant.Assessment;
import com.edu.domain.assistant.vo.AssessmentView;

import java.util.List;

public interface AssessmentDao {
    public int addOne(Assessment assessment);

    // 根据学号选出所有的评定表视图
    public List<AssessmentView> selectBySno(String sno);

    // 根据学号选出评定表视图
    public AssessmentView selectById(int id);

}
