package com.edu.assistant;

import com.edu.dao.assistant.CourseDao;
import com.edu.dao.base.DaoFactory;
import org.junit.Test;

/**
 * CourseTest : 课程表DAO测试
 */
public class CourseTest {

    CourseDao courseDao = DaoFactory.getInstance().getCourseDao();

    @Test
    public void testSelectCid(){
        String cid =  courseDao.selectCidByNamePrObjAndSub("专业概述","必修","本科生","1");
        System.out.println(cid);
    }

}
