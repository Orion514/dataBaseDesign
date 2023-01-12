package com.edu.dao.assistant;

import com.edu.domain.assistant.Audit;

import java.util.ArrayList;

//审核表
public interface AuditDao {
    //添加信息
    public void addAudit(Audit au);
    //根据是否通过的状态筛选信息
    public void selectAudit(Audit au);
    //更新状态信息
    public void updateAudit(Audit au);
    //求审核信息数量
    public int selectAllAudit();
    //根据学号筛选信息
    public  ArrayList<Audit> selectAuditBySnod(String sno_id);
    //根据课程号筛选信息
    public ArrayList<Audit> selectAuditByCid(String cid);
    //根据审核号筛选信息
    public ArrayList<Audit> selectAuditById(int id);

}
