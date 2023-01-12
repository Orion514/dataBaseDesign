package com.edu.dao.assistant.impl;

import com.edu.dao.assistant.AuditDao;
import com.edu.druid.DruidUtil;
import com.edu.domain.assistant.Audit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class AuditDaoImpl implements AuditDao {
    @Override
    public void addAudit(Audit au) {
        Connection con = null;
        try{
            con = DruidUtil.getDataSource().getConnection();
            //con= DaoBase.getConnection();
            String add_sql="insert into audit(id,sno_id,cid,audit_state,choice) values(?,?,?,?,?)";
            PreparedStatement psmt = con.prepareStatement(add_sql);
            psmt.setInt(1,au.getId());
            psmt.setString(2, au.getSno_id());
            psmt.setString(3,au.getCid());
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
    public void selectAudit(Audit au) {
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
    public void updateAudit(Audit au) {
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
    public ArrayList<Audit> selectAuditBySnod(String sno_id) {

        Connection con = null;
        //查询结果返回
        ResultSet resSet = null;
        ArrayList<Audit> list=new ArrayList<>();
        try{
            con = DruidUtil.getDataSource().getConnection();
            //con= DaoBase.getConnection();
            String select_sql="select * from audit where sno_id = ?";
            PreparedStatement psmt = con.prepareStatement(select_sql);
            psmt.setString(1,sno_id);
            resSet = psmt.executeQuery();
            int num = 0;
            //迭代器，while循环
            while (resSet.next()) {
                //函数有多种类型，根据获取的数值的类型决定
                //参数有两种类型，int是根据列号获取，String是根据列名获取
                //id = resSet.getInt(1);
                //String username = resSet.getString(1);
                //String password = resSet.getString("password");
                String id=resSet.getString("id");
                String sno_idd=resSet.getString("sno_id");
                String cid=resSet.getString("cid");
                String audit_state=resSet.getString("audit_state");
                String choice=resSet.getString("choice");
                System.out.println("sno_id: "+sno_idd+"  cid:  "+cid+"  audit_state:  "+audit_state+"  choice:  "+choice);
                Audit au=new Audit();
                au.setId(Integer.parseInt(id));
                au.setSno_id(sno_idd);
                au.setCid(cid);
                au.setAudit_state(audit_state);
                au.setChoice(Integer.parseInt(choice));
                list.add(au);
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

    @Override
    public ArrayList<Audit> selectAuditByCid(String cid) {

        Connection con = null;
        //查询结果返回
        ResultSet resSet = null;
        ArrayList<Audit> list=new ArrayList<>();
        try{
            con = DruidUtil.getDataSource().getConnection();
            //con= DaoBase.getConnection();
            String select_sql="select * from audit where cid = ?";
            PreparedStatement psmt = con.prepareStatement(select_sql);
            psmt.setString(1,String.valueOf(cid));
            resSet = psmt.executeQuery();
            //迭代器，while循环
            while (resSet.next()) {
                //函数有多种类型，根据获取的数值的类型决定
                //参数有两种类型，int是根据列号获取，String是根据列名获取
                //id = resSet.getInt(1);
                //String username = resSet.getString(1);
                //String password = resSet.getString("password");
                String id=resSet.getString("id");
                String sno_idd=resSet.getString("sno_id");
                String cidd=resSet.getString("cid");
                String audit_state=resSet.getString("audit_state");
                String choice=resSet.getString("choice");
                System.out.println("sno_id: "+sno_idd+"  cid:  "+cidd+"  audit_state:  "+audit_state+"  choice:  "+choice);
                Audit au=new Audit();
                au.setId(Integer.parseInt(id));
                au.setSno_id(sno_idd);
                au.setCid(cidd);
                au.setAudit_state(audit_state);
                au.setChoice(Integer.parseInt(choice));
                list.add(au);
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


    @Override
    public ArrayList<Audit> selectAuditById(int id) {
        Connection con = null;
        //查询结果返回
        ResultSet resSet = null;
        ArrayList<Audit> list=new ArrayList<>();
        try{
            con = DruidUtil.getDataSource().getConnection();
            //con= DaoBase.getConnection();
            String select_sql="select * from audit where id = ?";
            PreparedStatement psmt = con.prepareStatement(select_sql);
            psmt.setString(1,String.valueOf(id));
            resSet = psmt.executeQuery();
            //迭代器，while循环
            while (resSet.next()) {
                //函数有多种类型，根据获取的数值的类型决定
                //参数有两种类型，int是根据列号获取，String是根据列名获取
                //id = resSet.getInt(1);
                //String username = resSet.getString(1);
                //String password = resSet.getString("password");
                String idd=resSet.getString("id");
                String sno_idd=resSet.getString("sno_id");
                String cidd=resSet.getString("cid");
                String audit_state=resSet.getString("audit_state");
                String choice=resSet.getString("choice");
                System.out.println("sno_id: "+sno_idd+"  cid:  "+cidd+"  audit_state:  "+audit_state+"  choice:  "+choice);
                Audit au=new Audit();
                au.setId(Integer.parseInt(idd));
                au.setSno_id(sno_idd);
                au.setCid(cidd);
                au.setAudit_state(audit_state);
                au.setChoice(Integer.parseInt(choice));
                list.add(au);
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
