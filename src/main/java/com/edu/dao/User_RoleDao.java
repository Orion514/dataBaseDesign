package com.edu.dao;


import com.edu.po.User_Role;

public interface User_RoleDao {
    public int selectRoleIdByUserId(int userid);

    public void addUser_Role(User_Role ur);
}
