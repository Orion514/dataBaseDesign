package com.edu.assistant;

import com.edu.dao.assistant.CourseTeacherDao;
import com.edu.dao.base.DaoFactory;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * CourseTeacherTest : 授课教师表测试类
 */
public class CourseTeacherTest {

    CourseTeacherDao courseTeacherDao = DaoFactory.getInstance().getCourseTeacherDao();

    @Test
    public void testSelectId(){
        int res = courseTeacherDao.selectIdByTidAndCid("T1234567","C1234567");
        Assert.assertEquals(1,res);
    }

    @Test
    public void testSelectCidByTid(){
        List<String> res = courseTeacherDao.selectCidByTid("T1234567");
        for(String item : res){
            System.out.println(item);
        }
    }
}
