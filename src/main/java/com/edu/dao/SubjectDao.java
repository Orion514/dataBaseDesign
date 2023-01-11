package com.edu.dao;

import com.edu.po.Subject;

import java.util.List;

public interface SubjectDao {
    void addSubject();
    void deleteSubject();
    void updateSubject();
    List<Subject> selectallSubject();
    Subject selectSubject(String id);
}
