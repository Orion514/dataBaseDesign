package com.edu.dao;

import com.edu.po.Textbook;

import java.util.List;

public interface TextbookDao {
    public void AddTextbook(Textbook textbook);
    public List<Textbook> selectTextbookByUserid(int user_id);
    public List<Textbook> selectAll();
    public int updateResultById(Textbook textbook);
}
