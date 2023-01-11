package com.edu.dao;

import com.edu.druid.DruidUtil;

import com.edu.po.Participate;
import com.edu.po.Tutor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TutorDaoImpl implements TutorDao{
    @Override
    public Tutor selectTutorByUserId(int user_id){
        Connection conn = null;
        try {
            conn = DruidUtil.getDataSource().getConnection();
            String selectSql="select * from tutor where user_id=?";
            PreparedStatement ps = conn.prepareStatement(selectSql);
            ps.setInt(1 , user_id);
            ResultSet rs = ps.executeQuery();
            Tutor tutor = new Tutor();
            while(rs.next()){
                tutor.setId(rs.getString(1));
                tutor.setUser_id(rs.getInt(2));
                tutor.setName(rs.getString(3));
                tutor.setSubject_id(rs.getString(4));
            }
            rs.close();
            ps.close();
            conn.close();
            return tutor;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Tutor selectTutorById(String id){
        Connection conn = null;
        try {
            conn = DruidUtil.getDataSource().getConnection();
            String selectSql="select * from tutor where id=?";
            PreparedStatement ps = conn.prepareStatement(selectSql);
            ps.setString(1 , id);
            ResultSet rs = ps.executeQuery();
            Tutor tutor = new Tutor();
            while(rs.next()){
                tutor.setId(rs.getString(1));
                tutor.setUser_id(rs.getInt(2));
                tutor.setName(rs.getString(3));
                tutor.setSubject_id(rs.getString(4));
            }
            rs.close();
            ps.close();
            conn.close();
            return tutor;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Tutor> selectAllTutor(){
        Connection conn = null;
        try {
            conn = DruidUtil.getDataSource().getConnection();
            String selectSql="select * from tutor";
            PreparedStatement ps = conn.prepareStatement(selectSql);
            ResultSet rs = ps.executeQuery();
            List<Tutor> tutors=new ArrayList<>();

            while(rs.next()){
                Tutor tutor = new Tutor();
                tutor.setId(rs.getString(1));
                tutor.setUser_id(rs.getInt(2));
                tutor.setName(rs.getString(3));
                tutor.setSubject_id(rs.getString(4));
                tutors.add(tutor);
            }
            rs.close();
            ps.close();
            conn.close();
            return tutors;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void addTutor(Tutor tutor){
        Connection conn = null;
        try {
            conn = DruidUtil.getDataSource().getConnection();
            String insertsql="insert into tutor (id,user_id,name,subject_id) values(?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(insertsql);
            ps.setString(1 , tutor.getId());
            ps.setInt(2,tutor.getUser_id());
            ps.setString(3,tutor.getName());
            ps.setString(4,tutor.getSubject_id());
            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
