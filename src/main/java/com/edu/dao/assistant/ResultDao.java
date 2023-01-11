package com.edu.dao.assistant;

import com.edu.domain.assistant.Result;

//结果表
public interface ResultDao {

    //添加信息
    public void addResult(Result re);
    public void updateResult(Result re);

}
