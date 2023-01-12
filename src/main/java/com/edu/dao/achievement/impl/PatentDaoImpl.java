package com.edu.dao.achievement.impl;

import com.edu.dao.achievement.PatentDao;
import com.edu.druid.DruidUtil;
import com.edu.domain.achievement.Patent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PatentDaoImpl implements PatentDao {
    public void AddPatent(Patent patent){
        try {
            Connection conn = DruidUtil.getDataSource().getConnection();
            String insertsql="insert into patent (name,type,patent_no,time,status,rank,user_id,result) values(?,?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(insertsql);
            ps.setString(1, patent.getName());
            ps.setString(2, patent.getType());
            ps.setString(3, patent.getPatent_no());
            ps.setString(4, patent.getTime());
            ps.setString(5, patent.getStatus());
            ps.setInt(6, patent.getRank());
            ps.setInt(7, patent.getUser_id());
            ps.setString(8, patent.getResult());
            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<Patent> selectPatentByUserid(int user_id){
        try {
            Connection conn = DruidUtil.getDataSource().getConnection();
            String selectsql="select * from patent where user_id = ?";
            PreparedStatement ps = conn.prepareStatement(selectsql);
            ps.setInt(1, user_id);
            ResultSet rs = ps.executeQuery();
            List<Patent> patents = new ArrayList<>();
            while(rs.next()){
                Patent patent = new Patent();
                patent.setId(rs.getInt(1));
                patent.setType(rs.getString(2));
                patent.setPatent_no(rs.getString(3));
                patent.setTime(rs.getString(4));
                patent.setStatus(rs.getString(5));
                patent.setRank(rs.getInt(6));
                patent.setUser_id(rs.getInt(7));
                patent.setName(rs.getString(8));
                patent.setResult(rs.getString(9));
                patents.add(patent);
            }
            ps.close();
            conn.close();
            return patents;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Patent> selectAll(){
        try {
            Connection conn = DruidUtil.getDataSource().getConnection();
            String selectsql="select * from patent";
            PreparedStatement ps = conn.prepareStatement(selectsql);
            ResultSet rs = ps.executeQuery();
            List<Patent> patents = new ArrayList<>();
            while(rs.next()){
                Patent patent = new Patent();
                patent.setId(rs.getInt(1));
                patent.setType(rs.getString(2));
                patent.setPatent_no(rs.getString(3));
                patent.setTime(rs.getString(4));
                patent.setStatus(rs.getString(5));
                patent.setRank(rs.getInt(6));
                patent.setUser_id(rs.getInt(7));
                patent.setName(rs.getString(8));
                patent.setResult(rs.getString(9));
                patents.add(patent);
            }
            ps.close();
            conn.close();
            return patents;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int updateResultById(Patent patent){
        try {
            Connection conn = DruidUtil.getDataSource().getConnection();
            String updatesql="update patent set result = \'" + patent.getResult() + "\'where id =" + String.valueOf(patent.getId());
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
