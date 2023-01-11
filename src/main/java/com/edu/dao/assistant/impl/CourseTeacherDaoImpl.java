package com.edu.dao.assistant.impl;

import com.edu.dao.assistant.CourseTeacherDao;
import com.edu.dao.base.DaoBase;
import com.edu.domain.assistant.CourseTeacherView;
import com.edu.domain.assistant.vo.AssessmentView;

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


    private static final String selectCourseTeacherView = "select * from view_course_teacher";

    @Override
    public List<CourseTeacherView> getCourseTeacherAll() {
        List<CourseTeacherView> res = new ArrayList<>();
        Connection conn = null;
        PreparedStatement psmt = null;

        try{
            conn = getConnection();
            psmt = conn.prepareStatement(selectCourseTeacherView);

            ResultSet rs = psmt.executeQuery();
            while(rs.next()){
                CourseTeacherView courseTeacherView = new CourseTeacherView();
                courseTeacherView.setId(rs.getInt("id"));
                courseTeacherView.setCourse_id(rs.getString("course_id"));
                courseTeacherView.setCourse_name(rs.getString("course_name"));
                courseTeacherView.setCourse_property(rs.getString("course_property"));
                courseTeacherView.setCourse_hour(rs.getInt("course_hour"));
                courseTeacherView.setCourse_teach_object(rs.getString("course_teach_object"));
                courseTeacherView.setTeacher_name(rs.getString("teacher_name"));
                courseTeacherView.setTeach_student_num(rs.getInt("teach_student_num"));

                res.add(courseTeacherView);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return res;
    }


    private static final String selectViewById = "select * from view_course_teacher where id = ?";
    @Override
    public CourseTeacherView selectViewById(int id) {
        Connection conn = null;
        PreparedStatement psmt = null;
        CourseTeacherView courseTeacherView = null;

        try{
            conn = getConnection();
            psmt = conn.prepareStatement(selectViewById);
            psmt.setInt(1,id);

            ResultSet rs = psmt.executeQuery();
            if(rs.next()){
                courseTeacherView = new CourseTeacherView();
                courseTeacherView.setId(rs.getInt("id"));
                courseTeacherView.setCourse_id(rs.getString("course_id"));
                courseTeacherView.setCourse_name(rs.getString("course_name"));
                courseTeacherView.setCourse_property(rs.getString("course_property"));
                courseTeacherView.setCourse_hour(rs.getInt("course_hour"));
                courseTeacherView.setCourse_teach_object(rs.getString("course_teach_object"));
                courseTeacherView.setTeacher_name(rs.getString("teacher_name"));
                courseTeacherView.setTeach_student_num(rs.getInt("teach_student_num"));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return courseTeacherView;
    }
}
