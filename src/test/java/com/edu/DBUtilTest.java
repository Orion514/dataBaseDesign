package com.edu;

import com.edu.druid.DBUtil;
import com.edu.druid.DruidUtil;
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
    //


}
