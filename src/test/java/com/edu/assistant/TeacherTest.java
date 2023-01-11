package com.edu.assistant;

import com.edu.dao.assistant.CourseDao;
import com.edu.dao.assistant.TeacherDao;
import com.edu.dao.base.DaoFactory;
import org.junit.Assert;
import org.junit.Test;

/**
 * TeacherTest : 授课教师表测试类
 */
public class TeacherTest {

    TeacherDao teacherDao = DaoFactory.getInstance().getTeacherDao();

    @Test
    public void testSelect(){
        String res = teacherDao.selectTidByName("赵东");
        Assert.assertEquals("T1234567",res);
    }
}
