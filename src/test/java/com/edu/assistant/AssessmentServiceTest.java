package com.edu.assistant;

import com.edu.domain.assistant.vo.AssessmentView;
import com.edu.service.assistant.AssessmentService;
import com.edu.service.assistant.impl.AspirationFirstServiceImpl;
import org.junit.Test;

import java.sql.Date;

/**
 * AssessmentServiceTest : 服务层测试
 */
public class AssessmentServiceTest {

    AssessmentService assessmentService = new AspirationFirstServiceImpl();

    @Test
    public void testAddOne(){
        java.util.Date d = new java.util.Date();
        Date sqlD = new Date(d.getTime());

        AssessmentView assessmentView = new AssessmentView("周六", 1,"Y0000003","专业概述",68,"工学","必修","本科生","赵东","2023年第二学期","工作自述",sqlD,null,null,null);
        int res = assessmentService.addOne(assessmentView);
        System.out.println(res);
    }

}
