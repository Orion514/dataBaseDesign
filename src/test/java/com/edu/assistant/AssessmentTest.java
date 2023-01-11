package com.edu.assistant;

import com.edu.dao.assistant.AssessmentDao;
import com.edu.dao.base.DaoFactory;
import com.edu.domain.assistant.Assessment;
import com.edu.domain.assistant.vo.AssessmentView;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Date;
import java.util.List;

/**
 * AssessmentTest : 测试
 */
public class AssessmentTest {
    AssessmentDao assessmentDao = DaoFactory.getInstance().getAssessmentDao();

    @Test
    public void testAddOne(){
        int rowNum = 0;
        java.util.Date d = new java.util.Date();
        Date sqlD = new Date(d.getTime());

        Assessment assessment = new Assessment("S104",2,"工作自述",sqlD,null,null,null);

        rowNum = assessmentDao.addOne(assessment);

//        AssessmentView assessmentView = new AssessmentView("S1000f",null,null,48,null,null,null,null,null,null,null,null,null,null);
//
//        rowNum = assessmentDao.addOneByAll(assessmentView);

//        Assert.assertEquals(1,rowNum);
    }

    @Test
    public void testSelectBySno(){
        List<AssessmentView> assessmentViewList = assessmentDao.selectBySno("Y0000005");
        for(AssessmentView x : assessmentViewList ){
            System.out.println(x);
        }
    }


}
