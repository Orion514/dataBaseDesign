package com.edu.dao.achievement;

import com.edu.domain.achievement.Patent;

import java.util.List;

public interface PatentDao {
    public void AddPatent(Patent patent);
    public List<Patent> selectPatentByUserid(int user_id);
    public List<Patent> selectAll();
    public int updateResultById(Patent patent);
}
