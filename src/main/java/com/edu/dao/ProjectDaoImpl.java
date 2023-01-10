package com.edu.dao;

import com.edu.druid.DruidUtil;
import com.edu.po.Project;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProjectDaoImpl implements ProjectDao {
    @Override
    public Project selectProjectByIdentifier(String identifier){
        Connection conn = null;
        try {
            conn = DruidUtil.getDataSource().getConnection();
            String selectSql="select * from project where identifier=?";
            PreparedStatement ps = conn.prepareStatement(selectSql);
            ps.setString(1 , identifier);
            ResultSet rs = ps.executeQuery();
            Project proj = new Project();
            while(rs.next()){
                proj.setIdentifier(rs.getString(1));
                proj.setType(rs.getString(2));
                proj.setName(rs.getString(3));
                proj.setTutor_id(rs.getString(4));
                proj.setFunds(rs.getFloat(5));
                proj.setSurplus_funds(rs.getFloat(6));
            }
            rs.close();
            ps.close();
            conn.close();
            return proj;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void AddProject(Project project){
        Connection conn = null;
        try {
            conn = DruidUtil.getDataSource().getConnection();
            String insertsql="insert into project (identifier,type,name,tutor_id,funds,surplus_funds) values(?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(insertsql);
            ps.setString(1 , project.getIdentifier());
            ps.setString(2,project.getType());
            ps.setString(3,project.getName());
            ps.setString(4, project.getTutor_id());
            ps.setFloat(5,project.getFunds());
            ps.setFloat(6,project.getSurplus_funds());
            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    @Override
    public List<Project> selectProjectByTutorId(String tutor_id){
        Connection conn = null;
        try {
            conn = DruidUtil.getDataSource().getConnection();
            String selectSql="select * from project where tutor_id=?";
            PreparedStatement ps = conn.prepareStatement(selectSql);
            ps.setString(1 , tutor_id);
            ResultSet rs = ps.executeQuery();
            List<Project> projects=new ArrayList<>();

            while(rs.next()){
                Project proj = new Project();
                proj.setIdentifier(rs.getString(1));
                proj.setType(rs.getString(2));
                proj.setName(rs.getString(3));
                proj.setTutor_id(rs.getString(4));
                proj.setFunds(rs.getFloat(5));
                proj.setSurplus_funds(rs.getFloat(6));
                projects.add(proj);
            }
            rs.close();
            ps.close();
            conn.close();
            return projects;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void UpdateProject(Project project){
        Connection conn = null;
        try {
            conn = DruidUtil.getDataSource().getConnection();
            String updateSql="update project set type=?, name=?, tutor_id=?, funds=?, surplus_funds=? where identifier=?";
            PreparedStatement ps = conn.prepareStatement(updateSql);

            ps.setString(1,project.getType());
            ps.setString(2,project.getName());
            ps.setString(3, project.getTutor_id());
            ps.setFloat(4,project.getFunds());
            ps.setFloat(5,project.getSurplus_funds());
            ps.setString(6 , project.getIdentifier());
            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
