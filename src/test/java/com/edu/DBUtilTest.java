package com.edu;

import com.edu.po.Academic_Exchange;
import com.edu.dao.academic_exchange.Academic_ExchangeDaoImpl;
import com.edu.druid.DBUtil;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

public class DBUtilTest {

    @Test
    public void test() {
        String a = DBUtil.fixSqlFieldValue("3333'" );
        System.out.println(a);
    }

    @Test
    public void testConnect() throws SQLException {
        /*DataSource ds =  DruidUtil.getDataSource();
        System.out.println(ds);*/
        Academic_ExchangeDaoImpl academic_exchangeDao=new Academic_ExchangeDaoImpl();
        List<Academic_Exchange> list=academic_exchangeDao.selectAcademic_Exchange();
        for(Academic_Exchange l:list){
            System.out.println(l.getActivity_name());
        }
    }

}
