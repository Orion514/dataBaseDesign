package com.edu.dao.academic_exchange;

import com.edu.po.Academic_Exchange;

import java.util.List;

public interface Academic_ExchangeDao {
    void addAcademic_Exchange(Academic_Exchange academic_exchange);
    void deleteAcademic_Exchange();
    void updateAcademic_Exchange1(String student_id,int no,String audit_result);
    void updateAcademic_Exchange2(String student_id,String audit_result);
    List<Academic_Exchange> selectAcademic_Exchange();
}
