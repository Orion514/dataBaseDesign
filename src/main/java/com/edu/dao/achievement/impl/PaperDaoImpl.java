package com.edu.dao.achievement.impl;

import com.edu.dao.achievement.PaperDao;
import com.edu.druid.DruidUtil;
import com.edu.domain.achievement.Paper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PaperDaoImpl implements PaperDao {
    @Override
    public void AddPaper(Paper paper){
        Connection conn = null;
        try {
            conn = DruidUtil.getDataSource().getConnection();
            String insertsql="insert into paper (paper_name,press_name,status,time,type,lib,user_id,result) values(?,?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(insertsql);
            ps.setString(1, paper.getPaper_name());
            ps.setString(2, paper.getPress_name());
            ps.setString(3, paper.getStatus());
            ps.setString(4, paper.getTime());
            ps.setString(5, paper.getType());
            ps.setString(6, paper.getLib());
            ps.setInt(7 , paper.getUser_id());
            ps.setString(8, paper.getResult());
            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<Paper> selectPaperByUserid(int user_id){
        try {
            Connection conn = DruidUtil.getDataSource().getConnection();
            String selectsql="select * from paper where user_id = ?";
            PreparedStatement ps = conn.prepareStatement(selectsql);
            ps.setInt(1, user_id);
            ResultSet rs = ps.executeQuery();
            List<Paper> papers = new ArrayList<>();
            while(rs.next()){
                Paper paper = new Paper();
                paper.setId(rs.getInt(1));
                paper.setPaper_name(rs.getString(2));
                paper.setStatus(rs.getString(3));
                paper.setTime(rs.getString(4));
                paper.setType(rs.getString(5));
                paper.setLib(rs.getString(6));
                paper.setUser_id(rs.getInt(7));
                paper.setPress_name(rs.getString(8));
                paper.setResult(rs.getString(9));
                papers.add(paper);
            }
            ps.close();
            conn.close();
            return papers;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<Paper> selectAll(){
        try {
            Connection conn = DruidUtil.getDataSource().getConnection();
            String selectsql="select * from paper";
            PreparedStatement ps = conn.prepareStatement(selectsql);
            ResultSet rs = ps.executeQuery();
            List<Paper> papers = new ArrayList<>();
            while(rs.next()){
                Paper paper = new Paper();
                paper.setId(rs.getInt(1));
                paper.setPaper_name(rs.getString(2));
                paper.setStatus(rs.getString(3));
                paper.setTime(rs.getString(4));
                paper.setType(rs.getString(5));
                paper.setLib(rs.getString(6));
                paper.setUser_id(rs.getInt(7));
                paper.setPress_name(rs.getString(8));
                paper.setResult(rs.getString(9));
                papers.add(paper);
            }
            ps.close();
            conn.close();
            return papers;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int updateResultById(Paper paper){
        try {
            Connection conn = DruidUtil.getDataSource().getConnection();
            String updatesql="update paper set result = \'" + paper.getResult() + "\'where id =" + String.valueOf(paper.getId());
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
