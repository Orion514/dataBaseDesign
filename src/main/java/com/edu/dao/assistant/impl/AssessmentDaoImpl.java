package com.edu.dao.assistant.impl;

import com.edu.dao.assistant.AssessmentDao;
import com.edu.dao.base.DaoBase;
import com.edu.domain.assistant.Assessment;
import com.edu.domain.assistant.vo.AssessmentView;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * assessmentDaoImpl : 助教评定表Dao实现类
 */
public class AssessmentDaoImpl extends DaoBase implements AssessmentDao {
    private static final String Assessment_INSERT_ONE = "INSERT INTO assistant_assessment values(?,?,?,?,?,?,?)";

    @Override
    public int addOne(Assessment assessment){
        Connection conn = null;
        PreparedStatement psmt = null;
        int res = 0;

        try{
            conn = getConnection();
            psmt = conn.prepareStatement(Assessment_INSERT_ONE);
            psmt.setString(1,assessment.getSno_id());
            psmt.setInt(2,assessment.getCourse_teacher_id());
            psmt.setString(3,assessment.getWork_statement());
            psmt.setDate(4,assessment.getStatement_time());
            psmt.setString(5,assessment.getTeachar_appraise());
            psmt.setDate(6,assessment.getAppraise_time());
            psmt.setString(7,assessment.getAppraise_result());
            res = psmt.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            release(null,psmt,conn);
        }
        return res;
    }


    private static final String Assessment_SELECT_BY_SNO = "select * from view_assessment where sno = ? ";
    @Override
    public List<AssessmentView> selectBySno(String sno) {
        Connection conn = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;
        List<AssessmentView> res = new ArrayList<>();

        try{
            conn = getConnection();
            psmt = conn.prepareStatement(Assessment_SELECT_BY_SNO);
            psmt.setString(1,sno);
            rs = psmt.executeQuery();

            while(rs.next()){
                AssessmentView assessmentView = new AssessmentView();
                assessmentView.setStudent_id(rs.getString("sno"));
                assessmentView.setStudent_name(rs.getString("sname"));
                assessmentView.setCourse_name(rs.getString("course_name"));
                assessmentView.setCourse_student_num(rs.getInt("teach_student_num"));
                assessmentView.setSubject_name(rs.getString("sub_name"));
                assessmentView.setCourse_property(rs.getString("course_property"));
                assessmentView.setCourse_object(rs.getString("course_teach_object"));
                assessmentView.setTeacher_name(rs.getString("teacher_name"));
                assessmentView.setTeach_time(rs.getString("teach_time"));
                assessmentView.setWork_statement(rs.getString("work_statement"));
                assessmentView.setStatement_time(rs.getDate("statement_time"));
                assessmentView.setAppraise(rs.getString("teacher_appraise"));
                assessmentView.setAppraise_time(rs.getDate("appraise_time"));
                assessmentView.setAppraise_result(rs.getString("appraise_result"));

                res.add(assessmentView);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            release(null,psmt,conn);
        }
        return res;
    }


    private static final String Assessment_SELECT_BY_ID = "select * from view_assessment where id = ? ";
    @Override
    public AssessmentView selectById(int id) {
        Connection conn = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;
        AssessmentView assessmentView = new AssessmentView();

        try {
            conn = getConnection();
            psmt = conn.prepareStatement(Assessment_SELECT_BY_ID);
            psmt.setInt(1,id);

            rs = psmt.executeQuery();
            if(rs.next()){
                assessmentView.setStudent_id(rs.getString("sno"));
                assessmentView.setStudent_name(rs.getString("sname"));
                assessmentView.setCourse_name(rs.getString("course_name"));
                assessmentView.setCourse_student_num(rs.getInt("teach_student_num"));
                assessmentView.setSubject_name(rs.getString("sub_name"));
                assessmentView.setCourse_property(rs.getString("course_property"));
                assessmentView.setCourse_object(rs.getString("course_teach_object"));
                assessmentView.setTeacher_name(rs.getString("teacher_name"));
                assessmentView.setTeach_time(rs.getString("teach_time"));
                assessmentView.setWork_statement(rs.getString("work_statement"));
                assessmentView.setStatement_time(rs.getDate("statement_time"));
                assessmentView.setAppraise(rs.getString("teacher_appraise"));
                assessmentView.setAppraise_time(rs.getDate("appraise_time"));
                assessmentView.setAppraise_result(rs.getString("appraise_result"));
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            release(null,psmt,conn);
        }
        return assessmentView;
    }
}
