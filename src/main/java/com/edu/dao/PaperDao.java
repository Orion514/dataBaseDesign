package com.edu.dao;

import com.edu.po.Paper;

import java.util.List;

public interface PaperDao {
    public void AddPaper(Paper paper);
    public List<Paper> selectPaperByUserid(int user_id);
    public List<Paper> selectAll();
    public int updateResultById(Paper paper);
}
