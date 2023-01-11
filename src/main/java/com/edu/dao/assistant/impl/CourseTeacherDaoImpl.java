package com.edu.dao.assistant.impl;

import com.edu.dao.assistant.CourseTeacherDao;
import com.edu.dao.base.DaoBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * CourseTeacherDaoImpl : 授课教师表DAO实现类
 */
public class CourseTeacherDaoImpl extends DaoBase implements CourseTeacherDao {

    private static final String selectIDByTidAndCid = "select id from course_teacher where course_id = ? and teachar_id = ?";

    @Override
    public int selectIdByTidAndCid(String tid, String cid) {
        Connection conn = null;
        PreparedStatement psmt = null;
        int res = 0;

        try{
            conn = getConnection();
            psmt = conn.prepareStatement(selectIDByTidAndCid);
            psmt.setString(1,cid);
            psmt.setString(2,tid);

            ResultSet rs = psmt.executeQuery();
            if(rs.next()) res = rs.getInt("id");

        } catch (Exception e){
            e.printStackTrace();
        }
        return res;
    }

    private static final String selectCidByTid = "select course_id from course_teacher where teachar_id = ? ";
    @Override
    public List<String> selectCidByTid(String tid) {
        List<String> res = new ArrayList<>();

        Connection conn = null;
        PreparedStatement psmt = null;

        try{
            conn = getConnection();
            psmt = conn.prepareStatement(selectCidByTid);
            psmt.setString(1,tid);

            ResultSet rs = psmt.executeQuery();
            while(rs.next()){
                String cid = rs.getString("course_id");
                res.add(cid);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return res;
    }
}
