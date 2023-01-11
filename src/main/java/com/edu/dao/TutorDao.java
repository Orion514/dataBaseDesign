package com.edu.dao;

import com.edu.po.Tutor;

public interface TutorDao {
    public Tutor selectTutorByUserId(int user_id);

    public Tutor selectTutorById(String id);
}
