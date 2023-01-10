package com.edu.myproject;

import com.edu.druid.DruidUtil;
import com.edu.po.assistant_assessment;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class assistant_assessmentDaoImpl implements assistant_assessmentDao{

    @Override
    public void addAssistant_assessment(assistant_assessment as) {
        Connection con = null;
        try{
            con = DruidUtil.getDataSource().getConnection();
            //con= DaoBase.getConnection();
            String add_sql="insert into assistant_assessment(sno_id,course_teacher_id,work_statement,statement_time,teachar_appraise,appraise_time,appraise_result) values(?,?,?,?,?,?,?)";
            PreparedStatement psmt = con.prepareStatement(add_sql);
            psmt.setString(1,as.getSno_id());
            psmt.setInt(2, as.getCourse_teacher_id());
            psmt.setString(3,as.getWork_statement());
            psmt.setString(4,as.getStatement_time());
            psmt.setString(5,as.getTeachar_appraise());
            psmt.setString(6,as.getAppraise_time());
            psmt.setInt(7,as.getAppraise_result());
            psmt.executeUpdate();
            psmt.close();
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            try{
                con.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
