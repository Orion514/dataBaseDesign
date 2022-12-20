package com.edu.dao.base;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface Dao {
    // 进行连接
    Connection getConnection() throws SQLException;
    // 释放连接
    void release(ResultSet resSet, PreparedStatement psmt, Connection conn);
}
