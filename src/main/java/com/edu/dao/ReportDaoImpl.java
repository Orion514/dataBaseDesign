package com.edu.dao;

import com.edu.druid.DruidUtil;
import com.edu.po.Report;
import com.edu.po.Standard;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReportDaoImpl implements ReportDao{
    public void AddReport(Report report){
        try {
            Connection conn = DruidUtil.getDataSource().getConnection();
            String insertsql="insert into report (name,type,dept,time,rank,user_id,result) values(?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(insertsql);
            ps.setString(1, report.getName());
            ps.setString(2, report.getType());
            ps.setString(3, report.getDept());
            ps.setString(4, report.getTime());
            ps.setInt(5, report.getRank());
            ps.setInt(6, report.getUser_id());
            ps.setString(7, report.getResult());
            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Report> selectReportByUserId(int user_id){
        try {
            Connection conn = DruidUtil.getDataSource().getConnection();
            String selectsql="select * from report where user_id = ?";
            PreparedStatement ps = conn.prepareStatement(selectsql);
            ps.setInt(1, user_id);
            ResultSet rs = ps.executeQuery();
            List<Report> reports = new ArrayList<>();
            while(rs.next()){
                Report report = new Report();
                report.setId(rs.getInt(1));
                report.setName(rs.getString(2));
                report.setType(rs.getString(3));
                report.setDept(rs.getString(4));
                report.setTime(rs.getString(5));
                report.setRank(rs.getInt(6));
                report.setUser_id(rs.getInt(7));
                report.setResult(rs.getString(8));
                reports.add(report);
            }
            ps.close();
            conn.close();
            return reports;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Report> selectAll(){
        try {
            Connection conn = DruidUtil.getDataSource().getConnection();
            String selectsql="select * from report";
            PreparedStatement ps = conn.prepareStatement(selectsql);
            ResultSet rs = ps.executeQuery();
            List<Report> reports = new ArrayList<>();
            while(rs.next()){
                Report report = new Report();
                report.setId(rs.getInt(1));
                report.setName(rs.getString(2));
                report.setType(rs.getString(3));
                report.setDept(rs.getString(4));
                report.setTime(rs.getString(5));
                report.setRank(rs.getInt(6));
                report.setUser_id(rs.getInt(7));
                report.setResult(rs.getString(8));
                reports.add(report);
            }
            ps.close();
            conn.close();
            return reports;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int updateResultById(Report report){
        try {
            Connection conn = DruidUtil.getDataSource().getConnection();
            String updatesql="update report set result = \'" + report.getResult() + "\'where id =" + String.valueOf(report.getId());
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
