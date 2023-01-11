package com.edu.dao.common.impl;

import com.edu.domain.common.Subject_Leader;
import com.edu.dao.common.Subject_LeaderDao;
import com.edu.dao.base.DaoBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class Subject_LeaderDaoImpl extends DaoBase implements Subject_LeaderDao {
    private static final String select_sql1="select * from subject_leader";
    private static final String select_sql2="select * from subject_leader where " +
            "id=?";
    private static final String select_sql3="select * from subject_leader where " +
            "subject_id=?";
    private static final String select_sql4="select * from subject_leader where " +
            "user_id=?";
    private static final String insert_sql="insert into subject_leader(id,user_id,name,subject_id) " +
            "values (?,?,?,?)";
    @Override
    public void addSubject_Leader(Subject_Leader subject_leader) {
        try {
            Connection connection=getConnection();
            PreparedStatement preparedStatement= connection.prepareStatement(insert_sql);
            preparedStatement.setString(1,subject_leader.getId());
            preparedStatement.setInt(2,subject_leader.getUser_id());
            preparedStatement.setString(3,subject_leader.getName());
            preparedStatement.setString(4,subject_leader.getSubject_id());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteSubject_Leader() {

    }

    @Override
    public void UpdateSubject_Leader() {

    }

    @Override
    public List<Subject_Leader> SelectAllSubject_Leader() {
        return null;
    }


    @Override
    public Subject_Leader SelectSubject_LeaderById(String id) {
        Subject_Leader subject_leader=new Subject_Leader();
        try {
            Connection connection=getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement(select_sql2);
            preparedStatement.setString(1,id);
            ResultSet resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){
                if(resultSet.getString(1).equals(id)){
                    subject_leader.setId(resultSet.getString(1));
                    subject_leader.setUser_id(resultSet.getInt(2));
                    subject_leader.setName(resultSet.getString(3));
                    subject_leader.setSubject_id(resultSet.getString(4));
                }

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return subject_leader;
    }

    @Override
    public Subject_Leader SelectSubject_LeaderByUserId(int user_id) {
        Subject_Leader subject_leader=new Subject_Leader();
        try {
            Connection connection=getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement(select_sql4);
            preparedStatement.setInt(1,user_id);
            ResultSet resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){
                if(resultSet.getInt(2)==user_id){
                    subject_leader.setId(resultSet.getString(1));
                    subject_leader.setUser_id(resultSet.getInt(2));
                    subject_leader.setName(resultSet.getString(3));
                    subject_leader.setSubject_id(resultSet.getString(4));
                }

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return subject_leader;
    }

    @Override
    public Subject_Leader SelectSubject_LeaderBySubject_Id(String subject_id) {
        Subject_Leader subject_leader=new Subject_Leader();
        try {
            Connection connection=getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement(select_sql3);
            preparedStatement.setString(1,subject_id);
            ResultSet resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){
                if(resultSet.getString(4).equals(subject_id)){
                    subject_leader.setId(resultSet.getString(1));
                    subject_leader.setUser_id(resultSet.getInt(2));
                    subject_leader.setName(resultSet.getString(3));
                    subject_leader.setSubject_id(resultSet.getString(4));
                }

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return subject_leader;
    }
}
