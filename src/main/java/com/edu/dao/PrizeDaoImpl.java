package com.edu.dao;

import com.edu.druid.DruidUtil;
import com.edu.po.Paper;
import com.edu.po.Prize;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PrizeDaoImpl implements PrizeDao{
    public void AddPrize(Prize prize){
        try {
            Connection conn = DruidUtil.getDataSource().getConnection();
            String insertsql="insert into prize (name,type,prize,rank,time,user_id,result) values(?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(insertsql);
            ps.setString(1, prize.getName());
            ps.setString(2, prize.getType());
            ps.setString(3, prize.getPrize());
            ps.setInt(4, prize.getRank());
            ps.setString(5, prize.getTime());
            ps.setInt(6, prize.getUser_id());
            ps.setString(7,prize.getResult());
            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Prize> selectPrizeByUserid(int user_id){
        try {
            Connection conn = DruidUtil.getDataSource().getConnection();
            String selectsql="select * from prize where user_id = ?";
            PreparedStatement ps = conn.prepareStatement(selectsql);
            ps.setInt(1, user_id);
            ResultSet rs = ps.executeQuery();
            List<Prize> prizes = new ArrayList<>();
            while(rs.next()){
                Prize prize = new Prize();
                prize.setId(rs.getInt(1));
                prize.setName(rs.getString(2));
                prize.setType(rs.getString(3));
                prize.setPrize(rs.getString(4));
                prize.setRank(rs.getInt(5));
                prize.setTime(rs.getString(6));
                prize.setUser_id(rs.getInt(7));
                prize.setResult(rs.getString(8));
                prizes.add(prize);
            }
            ps.close();
            conn.close();
            return prizes;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Prize> selectAll(){
        try {
            Connection conn = DruidUtil.getDataSource().getConnection();
            String selectsql="select * from prize";
            PreparedStatement ps = conn.prepareStatement(selectsql);
            ResultSet rs = ps.executeQuery();
            List<Prize> prizes = new ArrayList<>();
            while(rs.next()){
                Prize prize = new Prize();
                prize.setId(rs.getInt(1));
                prize.setName(rs.getString(2));
                prize.setType(rs.getString(3));
                prize.setPrize(rs.getString(4));
                prize.setRank(rs.getInt(5));
                prize.setTime(rs.getString(6));
                prize.setUser_id(rs.getInt(7));
                prize.setResult(rs.getString(8));
                prizes.add(prize);
            }
            ps.close();
            conn.close();
            return prizes;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int updateResultById(Prize prize){
        try {
            Connection conn = DruidUtil.getDataSource().getConnection();
            String updatesql="update prize set result = \'" + prize.getResult() + "\'where id =" + String.valueOf(prize.getId());
            PreparedStatement ps = conn.prepareStatement(updatesql);
            int r = ps.executeUpdate();
            ps.close();
            conn.close();
            return r;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
