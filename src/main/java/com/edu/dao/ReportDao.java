package com.edu.dao;

import com.edu.po.Report;

import java.util.List;

public interface ReportDao {
    public void AddReport(Report report);
    public List<Report> selectReportByUserId(int user_id);
    public List<Report> selectAll();
    public int updateResultById(Report report);
}
