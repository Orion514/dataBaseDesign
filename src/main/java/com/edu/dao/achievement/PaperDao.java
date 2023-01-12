package com.edu.dao.achievement;

import com.edu.domain.achievement.Paper;

import java.util.List;

public interface PaperDao {
    public void AddPaper(Paper paper);
    public List<Paper> selectPaperByUserid(int user_id);
    public List<Paper> selectAll();
    public int updateResultById(Paper paper);
}
