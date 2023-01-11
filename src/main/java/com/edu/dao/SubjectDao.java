package com.edu.dao;

import com.edu.po.Subject;

import java.util.List;

public interface SubjectDao {
    void addSubject();
    void deleteSubject();
    void updateSubjectBysubject_Id1(String project_funds,String id);
    void updateSubjectBysubject_Id2(int academic_exchange_count,String id);
    void updateSubjectBysubject_Id3(int aspiration_count,String id);
    List<Subject> selectallSubject();
    Subject selectSubject(String id);
}
