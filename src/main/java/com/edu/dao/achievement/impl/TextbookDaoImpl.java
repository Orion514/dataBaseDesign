package com.edu.dao.achievement.impl;

import com.edu.dao.achievement.TextbookDao;
import com.edu.druid.DruidUtil;
import com.edu.domain.achievement.Textbook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TextbookDaoImpl implements TextbookDao {
    public void AddTextbook(Textbook textbook){
        try {
            Connection conn = DruidUtil.getDataSource().getConnection();
            String insertsql="insert into textbook (name,press,time,point,user_id,result) values(?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(insertsql);
            ps.setString(1, textbook.getName());
            ps.setString(2, textbook.getPress());
            ps.setString(3, textbook.getTime());
            ps.setInt(4, textbook.getPoint());
            ps.setInt(5, textbook.getUser_id());
            ps.setString(6, textbook.getResult());
            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Textbook> selectTextbookByUserid(int user_id){
        try {
            Connection conn = DruidUtil.getDataSource().getConnection();
            String selectsql="select * from textbook where user_id = ?";
            PreparedStatement ps = conn.prepareStatement(selectsql);
            ps.setInt(1, user_id);
            ResultSet rs = ps.executeQuery();
            List<Textbook> textbooks = new ArrayList<>();
            while(rs.next()){
                Textbook textbook = new Textbook();
                textbook.setId(rs.getInt(1));
                textbook.setName(rs.getString(2));
                textbook.setPress(rs.getString(3));
                textbook.setTime(rs.getString(4));
                textbook.setPoint(rs.getInt(5));
                textbook.setUser_id(rs.getInt(6));
                textbook.setResult(rs.getString(7));
                textbooks.add(textbook);
            }
            ps.close();
            conn.close();
            return textbooks;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Textbook> selectAll(){
        try {
            Connection conn = DruidUtil.getDataSource().getConnection();
            String selectsql="select * from textbook";
            PreparedStatement ps = conn.prepareStatement(selectsql);
            ResultSet rs = ps.executeQuery();
            List<Textbook> textbooks = new ArrayList<>();
            while(rs.next()){
                Textbook textbook = new Textbook();
                textbook.setId(rs.getInt(1));
                textbook.setName(rs.getString(2));
                textbook.setPress(rs.getString(3));
                textbook.setTime(rs.getString(4));
                textbook.setPoint(rs.getInt(5));
                textbook.setUser_id(rs.getInt(6));
                textbook.setResult(rs.getString(7));
                textbooks.add(textbook);
            }
            ps.close();
            conn.close();
            return textbooks;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int updateResultById(Textbook textbook){
        try {
            Connection conn = DruidUtil.getDataSource().getConnection();
            String updatesql="update textbook set result = \'" + textbook.getResult() + "\'where id =" + String.valueOf(textbook.getId());
            PreparedStatement ps = conn.prepareStatement(updatesql);
            int r = ps.executeUpdate();
            ps.close();
            conn.close();
            return r;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
