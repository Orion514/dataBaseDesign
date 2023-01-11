package com.edu.dao;

import com.edu.druid.DruidUtil;
import com.edu.po.Participate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ParticipateDaoImpl implements ParticipateDao {
    @Override
    public Participate getParticipateByPostgraduateId(String postgraduate_id){
        Connection conn = null;
        try {
            conn = DruidUtil.getDataSource().getConnection();
            String selectSql="select * from participate where postgraduate_id=?";
            PreparedStatement ps = conn.prepareStatement(selectSql);
            ps.setString(1 , postgraduate_id);
            ResultSet rs = ps.executeQuery();
            Participate participate = null;
            while(rs.next()){
                participate=new Participate();
                participate.setPostgraduate_id(rs.getString(1));
                participate.setProject_id(rs.getString(2));
                participate.setTime(rs.getString(3));
                participate.setUndertake(rs.getString(4));
                participate.setFunds(rs.getFloat(5));
            }
            rs.close();
            ps.close();
            conn.close();
            return participate;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void AddParticipate(Participate participate){
        Connection conn = null;
        try {
            conn = DruidUtil.getDataSource().getConnection();
            String insertsql="insert into participate (postgraduate_id,project_id,time,undertake,funds) values(?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(insertsql);
            ps.setString(1 , participate.getPostgraduate_id());
            ps.setString(2,participate.getProject_id());
            ps.setString(3,participate.getTime());
            ps.setString(4, participate.getUndertake());
            ps.setFloat(5,participate.getFunds());
            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void UpdateParticipate(Participate participate){
        Connection conn = null;
        try {
            conn = DruidUtil.getDataSource().getConnection();
            String insertsql="update participate set project_id=?, time=?, undertake=?, funds=? where postgraduate_id=?";
            PreparedStatement ps = conn.prepareStatement(insertsql);

            ps.setString(1,participate.getProject_id());
            ps.setString(2,participate.getTime());
            ps.setString(3, participate.getUndertake());
            ps.setFloat(4,participate.getFunds());
            ps.setString(5 , participate.getPostgraduate_id());
            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Participate> getAllParticipate(){
        Connection conn = null;
        try {
            conn = DruidUtil.getDataSource().getConnection();
            String selectSql="select * from participate";
            PreparedStatement ps = conn.prepareStatement(selectSql);
            ResultSet rs = ps.executeQuery();
            List<Participate> participates=new ArrayList<>();

            while(rs.next()){
                Participate participate = new Participate();
                participate.setPostgraduate_id(rs.getString(1));
                participate.setProject_id(rs.getString(2));
                participate.setTime(rs.getString(3));
                participate.setUndertake(rs.getString(4));
                participate.setFunds(rs.getFloat(5));
                participates.add(participate);
            }
            rs.close();
            ps.close();
            conn.close();
            return participates;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void DeleteParticipate(String postgraduate_id){
        Connection conn = null;
        try {
            conn = DruidUtil.getDataSource().getConnection();;
            String deleteSql="delete from participate where postgraduate_id=?";
            PreparedStatement ps = conn.prepareStatement(deleteSql);
            ps.setString(1 , postgraduate_id);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
