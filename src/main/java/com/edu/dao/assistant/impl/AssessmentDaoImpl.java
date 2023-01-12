package com.edu.dao.assistant.impl;

import com.edu.dao.assistant.AssessmentDao;
import com.edu.dao.base.DaoBase;
import com.edu.domain.assistant.Assessment;
import com.edu.domain.assistant.vo.AssessmentView;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
                assessmentView.setCourse_id(rs.getString("course_id"));
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

    public java.sql.Date strToDate(String stringDate) throws ParseException
    {

        SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("string:"+stringDate);

        Date stDate=sdf.parse(stringDate);                 //这里的Date是java.util.Date这个包里的
        System.out.println("util.Date:"+stDate);

        java.sql.Date startDate=new java.sql.Date(stDate.getTime());
        System.out.println("sql.Date:"+startDate);
        return startDate;
    }



    private static final String Assessment_SELECT_BY_Course_Teacher_Id = "select * from assistant_assessment where course_teacher_id = ? ";
    @Override
    public List<Assessment> selectBy_Course_Teacher_Id(int course_teacher_id) {
        Connection conn = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;
        List<Assessment> res = new ArrayList<>();

        try{
            conn = getConnection();
            psmt = conn.prepareStatement(Assessment_SELECT_BY_Course_Teacher_Id);
            psmt.setString(1,String.valueOf(course_teacher_id));
            rs = psmt.executeQuery();

            while(rs.next()){
                Assessment assessment=new Assessment();
                assessment.setSno_id(rs.getString("sno_id"));
                assessment.setCourse_teacher_id(Integer.parseInt(rs.getString("course_teacher_id")));;
                assessment.setWork_statement(rs.getString("work_statement"));

                String dd= rs.getString("statement_time");
                assessment.setStatement_time(strToDate(dd));

                if(rs.getString("appraise_result")!=null)
                {
                    assessment.setTeachar_appraise(rs.getString("teacher_appraise"));
                    String dd2= rs.getString("appraise_time");
                    assessment.setAppraise_time(strToDate(dd2));
                    assessment.setAppraise_result(rs.getString("appraise_result"));
                }
                res.add(assessment);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            release(null,psmt,conn);
        }
        return res;
    }



    private static final String Assessment_SELECT_BY_Sno_Id = "select * from assistant_assessment where sno_id = ? ";
    @Override
    public List<Assessment> Assessment_SELECT_BY_Sno_Id(String sno_id) {
        Connection conn = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;
        List<Assessment> res = new ArrayList<>();

        try{
            conn = getConnection();
            psmt = conn.prepareStatement(Assessment_SELECT_BY_Sno_Id);
            psmt.setString(1,String.valueOf(sno_id));
            rs = psmt.executeQuery();

            while(rs.next()){
                Assessment assessment=new Assessment();
                assessment.setSno_id(rs.getString("sno_id"));
                assessment.setCourse_teacher_id(Integer.parseInt(rs.getString("course_teacher_id")));;
                assessment.setWork_statement(rs.getString("work_statement"));

                String dd= rs.getString("statement_time");
                assessment.setStatement_time(strToDate(dd));
                if(rs.getString("appraise_result")!=null)
                {
                    assessment.setTeachar_appraise(rs.getString("teacher_appraise"));
                    String dd2= rs.getString("appraise_time");
                    assessment.setAppraise_time(strToDate(dd2));
                    assessment.setAppraise_result(rs.getString("appraise_result"));
                }
                res.add(assessment);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            release(null,psmt,conn);
        }
        return res;
    }





    private static final String Assessment_UPDATE_BY_Course_Teacher_SNO_Id = "update assistant_assessment set teacher_appraise =? , appraise_time = ? , appraise_result= ?  where sno_id = ? and course_teacher_id = ? ";
    @Override
    public void updateBy_Course_Teacher_Sno_Id(String teacher_appraise,Date appraise_time,String appraise_result,String sno_id,int course_teacher_id) {
        Connection conn = null;
        PreparedStatement psmt = null;

        try{
            conn = getConnection();
            psmt = conn.prepareStatement(Assessment_UPDATE_BY_Course_Teacher_SNO_Id);
            psmt.setString(1,teacher_appraise);
            psmt.setDate(2, (java.sql.Date) appraise_time);
            psmt.setString(3,appraise_result);
            psmt.setString(4,sno_id);
            psmt.setInt(5,course_teacher_id);
            psmt.executeUpdate();
            System.out.println("更新完毕");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            release(null,psmt,conn);
        }
    }



}
