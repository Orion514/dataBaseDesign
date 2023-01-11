package com.edu.dao.assistant;

import com.edu.domain.assistant.Assessment;
import com.edu.domain.assistant.vo.AssessmentView;

import java.util.List;

public interface AssessmentDao {
    public int addOne(Assessment assessment);

    public List<AssessmentView> selectBySno(String sno);

}
