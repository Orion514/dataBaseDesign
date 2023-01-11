package com.edu.dao;

import com.edu.druid.DruidUtil;
import com.edu.po.Postgraduate;
import com.edu.po.Tutor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PostgraduateDaoImpl implements PostgraduateDao{
    @Override
    public List<Postgraduate> selectPostgraduateByTutorId(String tutor_id){
        Connection conn = null;
        try {
            conn = DruidUtil.getDataSource().getConnection();
            String selectSql="select * from postgraduate where tutor_id=?";
            PreparedStatement ps = conn.prepareStatement(selectSql);
            ps.setString(1 , tutor_id);
            ResultSet rs = ps.executeQuery();
            List<Postgraduate> postgraduates=new ArrayList<>();

            while(rs.next()){
                Postgraduate postgraduate=new Postgraduate();
                postgraduate.setId(rs.getString(1));
                postgraduate.setName(rs.getString(2));
                postgraduate.setIdentity(rs.getString(3));
                postgraduate.setTutor_id(rs.getString(4));
                postgraduate.setUser_id(rs.getInt(5));
                postgraduates.add(postgraduate);
            }
            rs.close();
            ps.close();
            conn.close();
            return postgraduates;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Postgraduate selectPostgraduateByUserId(int user_id){
        Connection conn = null;
        try {
            conn = DruidUtil.getDataSource().getConnection();
            String selectSql="select * from postgraduate where user_id=?";
            PreparedStatement ps = conn.prepareStatement(selectSql);
            ps.setInt(1 , user_id);
            ResultSet rs = ps.executeQuery();
            Postgraduate postgraduate = new Postgraduate();
            while(rs.next()){
                postgraduate.setId(rs.getString(1));
                postgraduate.setName(rs.getString(2));
                postgraduate.setIdentity(rs.getString(3));
                postgraduate.setTutor_id(rs.getString(4));
                postgraduate.setUser_id(rs.getInt(5));
            }
            rs.close();
            ps.close();
            conn.close();
            return postgraduate;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    public Postgraduate selectPostgraduateById(String id){
        Connection conn = null;
        try {
            conn = DruidUtil.getDataSource().getConnection();
            String selectSql="select * from postgraduate where id=?";
            PreparedStatement ps = conn.prepareStatement(selectSql);
            ps.setString(1 , id);
            ResultSet rs = ps.executeQuery();
            Postgraduate postgraduate = new Postgraduate();
            while(rs.next()){
                postgraduate.setId(rs.getString(1));
                postgraduate.setName(rs.getString(2));
                postgraduate.setIdentity(rs.getString(3));
                postgraduate.setTutor_id(rs.getString(4));
                postgraduate.setUser_id(rs.getInt(5));
            }
            rs.close();
            ps.close();
            conn.close();
            return postgraduate;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addPostgraduate(Postgraduate pg){
        Connection conn = null;
        try {
            conn = DruidUtil.getDataSource().getConnection();
            String insertsql="insert into postgraduate (id,name,pgtype,tutor_id,user_id) values(?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(insertsql);
            ps.setString(1 , pg.getId());
            ps.setString(2,pg.getName());
            ps.setString(3,pg.getIdentity());
            ps.setString(4,pg.getTutor_id());
            ps.setInt(5,pg.getUser_id());
            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
