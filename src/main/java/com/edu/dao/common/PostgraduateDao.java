package com.edu.dao.common;

import com.edu.domain.common.Postgraduate;

import java.util.List;

public interface PostgraduateDao {
    public List<Postgraduate> selectPostgraduateByTutorId(String tutor_id);

    public Postgraduate selectPostgraduateByUserId(int user_id);

    public Postgraduate selectPostgraduateById(String id);

    public void addPostgraduate(Postgraduate pg);
}
