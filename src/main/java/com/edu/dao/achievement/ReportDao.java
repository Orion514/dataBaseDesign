package com.edu.dao.achievement;

import com.edu.domain.achievement.Report;

import java.util.List;

public interface ReportDao {
    public void AddReport(Report report);
    public List<Report> selectReportByUserId(int user_id);
    public List<Report> selectAll();
    public int updateResultById(Report report);
}
