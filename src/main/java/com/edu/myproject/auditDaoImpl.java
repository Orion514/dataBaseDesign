package com.edu.myproject;

import com.edu.dao.base.Dao;
import com.edu.dao.base.DaoBase;
import com.edu.dao.base.DaoFactory;
import com.edu.druid.DruidUtil;
import com.edu.po.audit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class auditDaoImpl implements auditDao{
    @Override
    public void addAudit(audit au) {
        Connection con = null;
        try{
            con = DruidUtil.getDataSource().getConnection();
            //con= DaoBase.getConnection();
            String add_sql="insert into audit(id,sno_id,cid,audit_state,choice) values(?,?,?,?,?)";
            PreparedStatement psmt = con.prepareStatement(add_sql);
            psmt.setInt(1,au.getId());
            psmt.setString(2, au.getSno_id());
            psmt.setInt(3,au.getCid());
            psmt.setString(4,au.getAudit_state());
            psmt.setInt(5,au.getChoice());
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
    public void selectAudit(audit au) {
        Connection con = null;
        //查询结果返回
        ResultSet resSet = null;
        try{
            con = DruidUtil.getDataSource().getConnection();
            //con= DaoBase.getConnection();
            String select_sql="select sno_id,cid from audit where audit_state = ?";
            PreparedStatement psmt = con.prepareStatement(select_sql);
            psmt.setString(1,au.getAudit_state());
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
                System.out.println("sno_id: "+sno_id+"  cid:  "+cid);
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
    }

    @Override
    public void updateAudit(audit au) {
        Connection con = null;
        try{
            con = DruidUtil.getDataSource().getConnection();
            //con= DaoBase.getConnection();
            String update_sql="update audit set audit_state = ? where id = ?";
            PreparedStatement psmt = con.prepareStatement(update_sql);
            psmt.setString(1,au.getAudit_state());
            psmt.setInt(2,au.getId());
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
    public int selectAllAudit() {
        Connection con = null;
        //查询结果返回
        ResultSet resSet = null;
        int num=0;
        try{
            con = DruidUtil.getDataSource().getConnection();
            //con= DaoBase.getConnection();
            String select_sql="select * from audit";
            PreparedStatement psmt = con.prepareStatement(select_sql);
            resSet = psmt.executeQuery();
            //迭代器，while循环
            while (resSet.next()) {
               num++;
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
        return num;
    }

    @Override
    public void selectAuditBySnod(String sno_id) {

        Connection con = null;
        //查询结果返回
        ResultSet resSet = null;
        try{
            con = DruidUtil.getDataSource().getConnection();
            //con= DaoBase.getConnection();
            String select_sql="select * from audit where sno_id = ?";
            PreparedStatement psmt = con.prepareStatement(select_sql);
            psmt.setString(1,sno_id);
            resSet = psmt.executeQuery();
            //迭代器，while循环
            while (resSet.next()) {
                //函数有多种类型，根据获取的数值的类型决定
                //参数有两种类型，int是根据列号获取，String是根据列名获取
                //id = resSet.getInt(1);
                //String username = resSet.getString(1);
                //String password = resSet.getString("password");
                String sno_idd=resSet.getString("sno_id");
                String cid=resSet.getString("cid");
                String audit_state=resSet.getString("audit_state");
                String choice=resSet.getString("choice");
                System.out.println("sno_id: "+sno_idd+"  cid:  "+cid+"  audit_state:  "+audit_state+"  choice:  "+choice);
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


    }

    //查看12
    //通过。。。不通过


}
