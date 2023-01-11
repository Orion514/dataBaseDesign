package com.edu.dao;

import com.edu.druid.DruidUtil;

import com.edu.po.Tutor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
}
