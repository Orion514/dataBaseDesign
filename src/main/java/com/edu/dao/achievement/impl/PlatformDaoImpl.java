package com.edu.dao.achievement.impl;

import com.edu.dao.achievement.PlatformDao;
import com.edu.druid.DruidUtil;
import com.edu.domain.achievement.Platform;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlatformDaoImpl implements PlatformDao {
    public void AddPlatform(Platform platform){
        try {
            Connection conn = DruidUtil.getDataSource().getConnection();
            String insertsql="insert into platform (name,dept,time,rank,user_id,result) values(?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(insertsql);
            ps.setString(1, platform.getName());
            ps.setString(2, platform.getDept());
            ps.setString(3, platform.getTime());
            ps.setInt(4, platform.getRank());
            ps.setInt(5, platform.getUser_id());
            ps.setString(6,platform.getResult());
            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Platform> selectPlatformByUserid(int user_id){
        try {
            Connection conn = DruidUtil.getDataSource().getConnection();
            String selectsql="select * from platform where user_id = ?";
            PreparedStatement ps = conn.prepareStatement(selectsql);
            ps.setInt(1, user_id);
            ResultSet rs = ps.executeQuery();
            List<Platform> platforms = new ArrayList<>();
            while(rs.next()){
                Platform platform = new Platform();
                platform.setId(rs.getInt(1));
                platform.setName(rs.getString(2));
                platform.setDept(rs.getString(3));
                platform.setTime(rs.getString(4));
                platform.setRank(rs.getInt(5));
                platform.setUser_id(rs.getInt(6));
                platform.setResult(rs.getString(7));
                platforms.add(platform);
            }
            ps.close();
            conn.close();
            return platforms;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Platform> selectAll(){
        try {
            Connection conn = DruidUtil.getDataSource().getConnection();
            String selectsql="select * from platform";
            PreparedStatement ps = conn.prepareStatement(selectsql);
            ResultSet rs = ps.executeQuery();
            List<Platform> platforms = new ArrayList<>();
            while(rs.next()){
                Platform platform = new Platform();
                platform.setId(rs.getInt(1));
                platform.setName(rs.getString(2));
                platform.setDept(rs.getString(3));
                platform.setTime(rs.getString(4));
                platform.setRank(rs.getInt(5));
                platform.setUser_id(rs.getInt(6));
                platform.setResult(rs.getString(7));
                platforms.add(platform);
            }
            ps.close();
            conn.close();
            return platforms;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int updateResultById(Platform platform){
        try {
            Connection conn = DruidUtil.getDataSource().getConnection();
            String updatesql="update platform set result = \'" + platform.getResult() + "\'where id =" + String.valueOf(platform.getId());
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
