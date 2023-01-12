package com.edu.dao.common;

import com.edu.domain.common.Tutor;

import java.util.List;

public interface TutorDao {
    public Tutor selectTutorByUserId(int user_id);

    public Tutor selectTutorById(String id);

    public List<Tutor> selectAllTutor();

    public void addTutor(Tutor tutor);
}
