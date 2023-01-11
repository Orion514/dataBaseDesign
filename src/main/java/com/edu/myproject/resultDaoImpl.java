package com.edu.myproject;

import com.edu.druid.DruidUtil;
import com.edu.po.result;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class resultDaoImpl implements resultDao{


    @Override
    public void addResult(result re) {
        Connection con = null;
        try{
            con = DruidUtil.getDataSource().getConnection();
            String add_sql="insert into result(sno_id,cid) values(?,?)";
            PreparedStatement psmt = con.prepareStatement(add_sql);
            psmt.setString(1,re.getSno_id());
            psmt.setInt(2, re.getCid());
            psmt.executeUpdate();
            psmt.close();
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            try{
                con.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public void updateResult(result re) {


    }
}
