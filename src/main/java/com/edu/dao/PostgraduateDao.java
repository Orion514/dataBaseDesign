package com.edu.dao;



import com.edu.po.Postgraduate;

import java.util.List;

public interface PostgraduateDao {
    public List<Postgraduate> selectPostgraduateByTutorId(String tutor_id);

    public Postgraduate selectPostgraduateByUserId(int user_id);

    public Postgraduate selectPostgraduateById(String id);
}
