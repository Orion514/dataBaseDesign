package com.edu.dao;

import com.edu.po.Platform;

import java.util.List;

public interface PlatformDao {
    public void AddPlatform(Platform platform);
    public List<Platform> selectPlatformByUserid(int user_id);
    public List<Platform> selectAll();
    public int updateResultById(Platform platform);
}
