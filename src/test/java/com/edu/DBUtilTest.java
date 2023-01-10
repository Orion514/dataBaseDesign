package com.edu;

import com.edu.dao.base.DaoFactory;
import com.edu.druid.DBUtil;
import com.edu.druid.DruidUtil;
import com.edu.po.assistant_assessment;
import com.edu.po.audit;
import com.edu.po.result;
import org.junit.Test;

import javax.sql.DataSource;

public class DBUtilTest {

    @Test
    public void test() {
        String a = DBUtil.fixSqlFieldValue("3333'" );
        System.out.println(a);
    }

    @Test
    public void testConnect(){
        DataSource ds =  DruidUtil.getDataSource();
        System.out.println(ds);
    }

    @Test
    public void test1()
    {
        result re=new result();
        re.setSno_id("12345678");
        re.setCid(1);
        DaoFactory.getInstance().getResultDao().addResult(re);
        System.out.println("添加成功");
    }
    @Test
    public void test2()
    {
        audit au=new audit();
        au.setId(1);
        au.setSno_id("12345678");
        au.setCid(1);
        au.setAudit_state("通过");
        au.setChoice(2);
        DaoFactory.getInstance().getAuditDao().addAudit(au);
        System.out.println("添加成功");
    }
    @Test
    public void test3()
    {
        audit au=new audit();
        au.setId(1);
        au.setAudit_state("不通过");
        DaoFactory.getInstance().getAuditDao().updateAudit(au);
        System.out.println("修改成功");
    }
    @Test
    public void test4()
    {
        audit au=new audit();
        au.setAudit_state("不通过");
        DaoFactory.getInstance().getAuditDao().selectAudit(au);
        System.out.println("查询成功");
    }
    @Test
    public void test5()
    {
        assistant_assessment as=new assistant_assessment();
        as.setSno_id("12345658");
        as.setCourse_teacher_id(12);
        as.setWork_statement("jiiji");
        as.setStatement_time("2023-1-10");
        as.setTeachar_appraise("好");
        as.setAppraise_time("2022-1-10");
        as.setAppraise_result(1);
        DaoFactory.getInstance().getAssistant_assessmentDao().addAssistant_assessment(as);
        System.out.println("添加成功");
    }

    @Test
    public void test6()
    {
        String sno_id="12345678";
        DaoFactory.getInstance().getAuditDao().selectAuditBySnod(sno_id);
    }

}
