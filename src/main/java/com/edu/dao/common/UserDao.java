package com.edu.dao.common;
import com.edu.domain.common.User;
public interface UserDao {
    public User selectUserByAccount(String account);

    public void addUser(User user);
}
