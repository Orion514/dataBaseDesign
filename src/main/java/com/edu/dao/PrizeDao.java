package com.edu.dao;

import com.edu.po.Prize;
import com.edu.po.Report;

import java.util.List;

public interface PrizeDao {
    public void AddPrize(Prize prize);
    public List<Prize> selectPrizeByUserid(int user_id);
    public List<Prize> selectAll();
    public int updateResultById(Prize prize);
}
