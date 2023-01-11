package com.edu.dao.common;


import com.edu.domain.common.User_Role;

public interface User_RoleDao {
    public int selectRoleIdByUserId(int userid);

    public void addUser_Role(User_Role ur);
}
