package com.edu.dao.achievement;

import com.edu.domain.achievement.Standard;

import java.util.List;

public interface StandardDao {
    public void AddStandard(Standard standard);
    public List<Standard> selectStandardByUserid(int user_id);
    public List<Standard> selectAll();
    public int updateResultById(Standard standard);
}
