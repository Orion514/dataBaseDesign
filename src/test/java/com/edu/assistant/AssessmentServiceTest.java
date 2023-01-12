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

        AssessmentView assessmentView = new AssessmentView("Y0000003","赵四","C1345672",
                "专业概述",2,44,"工学","必修",
                "本科生","赵东","2023年第二学期","助教工作",sqlD,
                null,null,null);
        int res = assessmentService.addOne(assessmentView);
        System.out.println(res);
    }

}
