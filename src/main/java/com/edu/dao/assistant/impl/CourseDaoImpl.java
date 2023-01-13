package com.edu.dao.assistant.impl;

import com.edu.dao.assistant.CourseDao;
import com.edu.dao.base.DaoBase;
import com.edu.domain.assistant.Course;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

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

    private static final String selectCourseByCid = "select * from course where cid = ?";

    @Override
    public ArrayList<Course> selectCourseByCid(String cid) {
        ArrayList<Course> cou = new ArrayList<>();
        Connection conn = null;
        PreparedStatement psmt = null;

        try{
            conn = getConnection();
            psmt = conn.prepareStatement(selectCourseByCid);
            psmt.setString(1,cid);
            ResultSet rs = psmt.executeQuery();
            while(rs.next()){
                String cidd=rs.getString("cid");
                String name=rs.getString("name");
                String property=rs.getString("property");
                String teach_object=rs.getString("teach_object");
                String subject_id=rs.getString("subject_id");
                String hour=rs.getString("hour");
                Course cc=new Course();
                cc.setCid(cidd);
                cc.setName(name);
                cc.setProperty(property);
                cc.setTeach_object(teach_object);
                cc.setSubject_id((subject_id));
                cc.setHour(Integer.parseInt(hour));
                cou.add(cc);

            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return cou;
    }
}
