package com.edu.dao;

import com.edu.druid.DruidUtil;
import com.edu.po.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class User_RoleDaoImpl implements User_RoleDao{
    @Override
    public int selectRoleIdByUserId(int userid){
        Connection conn = null;
        try {
            conn = DruidUtil.getDataSource().getConnection();
            String selectSql="select role_id from user_role where user_id=?";
            PreparedStatement ps = conn.prepareStatement(selectSql);
            ps.setInt(1 , userid);
            ResultSet rs = ps.executeQuery();
            int roleid=-1;
            while(rs.next()){
                roleid=rs.getInt(1);
            }

            rs.close();
            ps.close();
            conn.close();
            return roleid;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
}
