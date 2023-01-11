package com.edu.dao.assistant.impl;

import com.edu.dao.assistant.CourseDao;
import com.edu.dao.base.DaoBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * CourseDao : 中文
 */
public class CourseDaoImpl extends DaoBase implements CourseDao {

    private static final String selectCID = "select cid from course where name = ? and property = ? and teach_object = ? and subject_id = ?";

    @Override
    public String selectCidByNamePrObjAndSub(String name, String property, String teach_object, String sub_id) {
        Connection conn = null;
        PreparedStatement psmt = null;
        String res = "";

        try{
            conn = getConnection();
            psmt = conn.prepareStatement(selectCID);
            psmt.setString(1,name);
            psmt.setString(2,property);
            psmt.setString(3,teach_object);
            psmt.setString(4,sub_id);

            ResultSet rs = psmt.executeQuery();
            if(rs.next()) res = rs.getString("cid");

        } catch (Exception e){
            e.printStackTrace();
        }
        return res;
    }
}
