package com.edu.dao.assistant.impl;

import com.edu.dao.assistant.StudentDao;
import com.edu.dao.base.DaoBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * StudentDaoImpl : 研究生表实现类
 */
public class StudentDaoImpl extends DaoBase implements StudentDao {

    private static final String selectSubIdBySno = "select subject_id from tutor as tu,postgraduate as p where p.tutor_id = tu.id and p.id = ?";

    @Override
    public String getSubIdBySno(String sno) {
        Connection conn = null;
        PreparedStatement psmt = null;
        String res = "";

        try{
            conn = getConnection();
            psmt = conn.prepareStatement(selectSubIdBySno);
            psmt.setString(1,sno);

            ResultSet rs = psmt.executeQuery();
            if(rs.next()) res = rs.getString("subject_id");

        } catch (Exception e){
            e.printStackTrace();
        }
        return res;
    }


    private static final String selectSubNameBySno = "select sub.name from subject as sub, tutor as tu,postgraduate as p " +
            "where p.tutor_id = tu.id and sub.id = tu.subject_id and p.id = ?";
    @Override
    public String getSubNameBySno(String sno) {
        Connection conn = null;
        PreparedStatement psmt = null;
        String res = "";

        try{
            conn = getConnection();
            psmt = conn.prepareStatement(selectSubNameBySno);
            psmt.setString(1,sno);

            ResultSet rs = psmt.executeQuery();
            if(rs.next()) res = rs.getString("name");

        } catch (Exception e){
            e.printStackTrace();
        }
        return res;
    }

}
