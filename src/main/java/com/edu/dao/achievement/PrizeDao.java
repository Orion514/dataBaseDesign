package com.edu.dao.achievement;

import com.edu.domain.achievement.Prize;

import java.util.List;

public interface PrizeDao {
    public void AddPrize(Prize prize);
    public List<Prize> selectPrizeByUserid(int user_id);
    public List<Prize> selectAll();
    public int updateResultById(Prize prize);
}
