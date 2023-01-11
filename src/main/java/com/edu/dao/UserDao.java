package com.edu.dao;
import com.edu.po.User;
public interface UserDao {
    public User selectUserByAccount(String account);
}
