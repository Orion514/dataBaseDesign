package com.edu.dao.assistant.impl;

import com.edu.dao.assistant.TeacherDao;
import com.edu.dao.base.DaoBase;
import com.edu.druid.DruidUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * TeacherDaoImpl : 中文
 */
public class TeacherDaoImpl extends DaoBase implements TeacherDao {

    private static final String selectTID = "select id from teachar where name = ?";
    @Override
    public String selectTidByName(String name) {
        Connection conn = null;
        PreparedStatement psmt = null;
        String res = "";

        try{
            conn = getConnection();
            psmt = conn.prepareStatement(selectTID);
            psmt.setString(1,name);

            ResultSet rs = psmt.executeQuery();
            if(rs.next()) res = rs.getString("id");

        } catch (Exception e){
            e.printStackTrace();
        }
        return res;
    }

    private static final String selectTTID = "select id from teachar where user_id = ?";
    @Override
    public String selectTidByUId(int user_id) {
        Connection conn = null;
        PreparedStatement psmt = null;
        String res = "";

        try{
            conn = DruidUtil.getDataSource().getConnection();
            psmt = conn.prepareStatement(selectTTID);
            psmt.setString(1,String.valueOf(user_id));

            ResultSet rs = psmt.executeQuery();
            if(rs.next()) res = rs.getString("id");

        } catch (Exception e){
            e.printStackTrace();
        }
        return res;
    }
}
