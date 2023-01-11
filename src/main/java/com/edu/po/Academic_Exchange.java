package com.edu.po;


import java.sql.Timestamp;
import java.util.Date;

public class Academic_Exchange {
    private String student_id;
    private int no;
    private String activity_name;
    private String location;
    private Date time;
    private String report_name;
    private String image;
    private String notes;
    private String subject_leader_id;
    private String audit_result;

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getActivity_name() {
        return activity_name;
    }

    public void setActivity_name(String activity_name) {
        this.activity_name = activity_name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getReport_name() {
        return report_name;
    }

    public void setReport_name(String report_name) {
        this.report_name = report_name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getNotes() {

        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getSubject_leader_id() {
        return subject_leader_id;
    }

    public void setSubject_leader_id(String subject_leader_id) {
        this.subject_leader_id = subject_leader_id;
    }

    public String getAudit_result() {
        return audit_result;
    }

    public void setAudit_result(String audit_result) {
        this.audit_result = audit_result;
    }
}
