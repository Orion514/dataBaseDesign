package com.edu.dao.common.impl;

import com.edu.domain.common.Subject;
import com.edu.dao.common.SubjectDao;
import com.edu.dao.base.DaoBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class SubjectDaoImpl extends DaoBase implements SubjectDao {
    private static final String update_sql1="";
    private static final String update_sql2="update subject set academic_exchange_count=? where " +
            "id=?";
    private static final String update_sql3="";

    private static final String select_sql1="select * from subject";
    private static final String select_sql2="select * from subject where " +
            "id=?";
    @Override
    public void addSubject() {

    }

    @Override
    public void deleteSubject() {

    }

    @Override
    public void updateSubjectBysubject_Id1(String project_funds, String id) {

    }

    @Override
    public void updateSubjectBysubject_Id2(int academic_exchange_count, String id) {
        try {
            Connection connection=getConnection();
            PreparedStatement preparedStatement= connection.prepareStatement(update_sql2);
            preparedStatement.setInt(1,academic_exchange_count);
            preparedStatement.setString(2,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateSubjectBysubject_Id3(int aspiration_count, String id) {

    }


    @Override
    public List<Subject> selectallSubject() {
        return null;
    }

    @Override
    public Subject selectSubject(String id) {
        Subject subject=new Subject();
        try {
            Connection connection=getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement(select_sql2);
            preparedStatement.setString(1,id);
            ResultSet resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){
                if(resultSet.getString(1).equals(id)){
                    subject.setId(resultSet.getString(1));
                    subject.setName(resultSet.getString(2));
                    subject.setProject_funds(resultSet.getString(3));
                    subject.setAcademic_exchange_count(resultSet.getInt(4));
                    subject.setAspiration_count(resultSet.getInt(5));
                }

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return subject;
    }
}
