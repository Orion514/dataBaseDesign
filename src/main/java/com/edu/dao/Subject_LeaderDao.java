package com.edu.dao;

import com.edu.po.Subject_Leader;

import java.util.List;

public interface Subject_LeaderDao {
    void addSubject_Leader(Subject_Leader subject_leader);
    void deleteSubject_Leader();
    void UpdateSubject_Leader();
    List<Subject_Leader> SelectAllSubject_Leader();
    Subject_Leader SelectSubject_LeaderById(String id);
    Subject_Leader SelectSubject_LeaderByUserId(int user_id);
    Subject_Leader SelectSubject_LeaderBySubject_Id(String subject_id);
}
