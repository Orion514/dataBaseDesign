package com.edu.dao.base;

import com.edu.druid.DruidUtil;

import java.sql.*;

public class DaoBase implements Dao {
    /**
     * 得到连接
     * @return 返回数据库连接对象
     * @throws SQLException
     */
    @Override
    public Connection getConnection() throws SQLException {
        return DruidUtil.getDataSource().getConnection();
    }

    /**
     * 释放连接
     * @param resSet 结果对象
     * @param psmt statement对象
     * @param conn 连接对象
     */
    @Override
    public void release(ResultSet resSet, PreparedStatement psmt, Connection conn) {
        try {
            if (resSet != null) resSet.close();
            if (psmt != null) psmt.close();
            if (conn != null) conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
