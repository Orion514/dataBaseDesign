package com.edu.dao.assistant.impl;

import com.edu.dao.assistant.ResultDao;
import com.edu.druid.DruidUtil;
import com.edu.domain.assistant.Result;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ResultDaoImpl implements ResultDao {



    @Override
    public void addResult(Result re) {
        Connection con = null;
        try{
            con = DruidUtil.getDataSource().getConnection();
            String add_sql="insert into Result(sno_id,cid) values(?,?)";
            PreparedStatement psmt = con.prepareStatement(add_sql);
            psmt.setString(1,re.getSno_id());
            psmt.setString(2, re.getCid());
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
    public void updateResult(Result re) {


    }

    @Override
    public ArrayList<Result> selectResult(Result re) {
        Connection con = null;
        //查询结果返回
        ResultSet resSet = null;
        ArrayList<Result> list=new ArrayList<>();
        try{
            con = DruidUtil.getDataSource().getConnection();
            String select_sql="select * from  Result where sno_id = ?";
            PreparedStatement psmt = con.prepareStatement(select_sql);
            psmt.setString(1,re.getSno_id());
            resSet = psmt.executeQuery();
            //迭代器，while循环
            while (resSet.next()) {
                //函数有多种类型，根据获取的数值的类型决定
                //参数有两种类型，int是根据列号获取，String是根据列名获取
                //id = resSet.getInt(1);
                //String username = resSet.getString(1);
                //String password = resSet.getString("password");
                String sno_id=resSet.getString("sno_id");
                String cid=resSet.getString("cid");

                Result ree=new Result();
                ree.setSno_id(sno_id);
                ree.setCid(cid);
                list.add(ree);
            }
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
        return list;
    }
}
