package com.edu.dao;

import com.edu.druid.DruidUtil;
import com.edu.po.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao{

    @Override
    public User selectUserByAccount(String account){
        Connection conn = null;
        try {
            conn = DruidUtil.getDataSource().getConnection();
            String selectSql="select * from myuser where account=?";
            PreparedStatement ps = conn.prepareStatement(selectSql);
            ps.setString(1 , account);
            ResultSet rs = ps.executeQuery();
            User user = new User();
            while(rs.next()) {
                user.setId(rs.getInt(1));
                user.setAccount(rs.getString(2));
                user.setPassword(rs.getString(3));

            }
            rs.close();
            ps.close();
            conn.close();
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

}
