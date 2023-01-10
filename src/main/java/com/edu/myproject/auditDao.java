package com.edu.myproject;

import com.edu.po.audit;

//审核表
public interface auditDao {
    //添加信息
    public void addAudit(audit au);
    //根据是否通过的状态筛选信息
    public void selectAudit(audit au);
    //更新状态信息
    public void updateAudit(audit au);
    //求审核信息数量
    public int selectAllAudit();
    //根据学号筛选信息
    public void selectAuditBySnod(String sno_id);


}
