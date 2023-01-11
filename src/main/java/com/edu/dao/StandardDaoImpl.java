package com.edu.dao;

import com.edu.druid.DruidUtil;
import com.edu.po.Prize;
import com.edu.po.Standard;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StandardDaoImpl implements StandardDao{
    public void AddStandard(Standard standard){
        try {
            Connection conn = DruidUtil.getDataSource().getConnection();
            String insertsql="insert into standard (std_name,type,time,user_id,result) values(?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(insertsql);
            ps.setString(1, standard.getStd_name());
            ps.setString(2, standard.getType());
            ps.setString(3, standard.getTime());
            ps.setInt(4, standard.getUser_id());
            ps.setString(5, standard.getResult());
            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<Standard> selectStandardByUserid(int user_id){
        try {
            Connection conn = DruidUtil.getDataSource().getConnection();
            String selectsql="select * from standard where user_id = ?";
            PreparedStatement ps = conn.prepareStatement(selectsql);
            ps.setInt(1, user_id);
            ResultSet rs = ps.executeQuery();
            List<Standard> standards = new ArrayList<>();
            while(rs.next()){
                Standard standard = new Standard();
                standard.setId(rs.getInt(1));
                standard.setStd_name(rs.getString(2));
                standard.setType(rs.getString(3));
                standard.setTime(rs.getString(4));
                standard.setUser_id(rs.getInt(5));
                standard.setResult(rs.getString(6));
                standards.add(standard);
            }
            ps.close();
            conn.close();
            return standards;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Standard> selectAll(){
        try {
            Connection conn = DruidUtil.getDataSource().getConnection();
            String selectsql="select * from standard";
            PreparedStatement ps = conn.prepareStatement(selectsql);
            ResultSet rs = ps.executeQuery();
            List<Standard> standards = new ArrayList<>();
            while(rs.next()){
                Standard standard = new Standard();
                standard.setId(rs.getInt(1));
                standard.setStd_name(rs.getString(2));
                standard.setType(rs.getString(3));
                standard.setTime(rs.getString(4));
                standard.setUser_id(rs.getInt(5));
                standard.setResult(rs.getString(6));
                standards.add(standard);
            }
            ps.close();
            conn.close();
            return standards;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int updateResultById(Standard standard){
        try {
            Connection conn = DruidUtil.getDataSource().getConnection();
            String updatesql="update standard set result = \'" + standard.getResult() + "\'where id =" + String.valueOf(standard.getId());
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
