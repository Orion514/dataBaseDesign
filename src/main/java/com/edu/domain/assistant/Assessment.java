package com.edu.domain.assistant;

import java.sql.Date;

/**
 * Assessment : 助教评定表
 */
public class Assessment {
    private String sno_id;
    private int course_teacher_id;
    private String work_statement;
    private Date statement_time;
    private String teachar_appraise;
    private Date appraise_time;
    private String appraise_result;


    public Assessment() {
    }

    public Assessment(String sno_id, int course_teacher_id, String work_statement, Date statement_time, String teachar_appraise, Date appraise_time, String appraise_result) {
        this.sno_id = sno_id;
        this.course_teacher_id = course_teacher_id;
        this.work_statement = work_statement;
        this.statement_time = statement_time;
        this.teachar_appraise = teachar_appraise;
        this.appraise_time = appraise_time;
        this.appraise_result = appraise_result;
    }

    @Override
    public String toString() {
        return "Assessment{" +
                "sno_id='" + sno_id + '\'' +
                ", course_teacher_id=" + course_teacher_id +
                ", work_statement='" + work_statement + '\'' +
                ", statement_time=" + statement_time +
                ", teachar_appraise='" + teachar_appraise + '\'' +
                ", appraise_time=" + appraise_time +
                ", appraise_result='" + appraise_result + '\'' +
                '}';
    }

    public String getSno_id() {
        return sno_id;
    }

    public void setSno_id(String sno_id) {
        this.sno_id = sno_id;
    }

    public int getCourse_teacher_id() {
        return course_teacher_id;
    }

    public void setCourse_teacher_id(int course_teacher_id) {
        this.course_teacher_id = course_teacher_id;
    }

    public String getWork_statement() {
        return work_statement;
    }

    public void setWork_statement(String work_statement) {
        this.work_statement = work_statement;
    }

    public Date getStatement_time() {
        return statement_time;
    }

    public void setStatement_time(Date statement_time) {
        this.statement_time = statement_time;
    }

    public String getTeachar_appraise() {
        return teachar_appraise;
    }

    public void setTeachar_appraise(String teachar_appraise) {
        this.teachar_appraise = teachar_appraise;
    }

    public Date getAppraise_time() {
        return appraise_time;
    }

    public void setAppraise_time(Date appraise_time) {
        this.appraise_time = appraise_time;
    }

    public String getAppraise_result() {
        return appraise_result;
    }

    public void setAppraise_result(String appraise_result) {
        this.appraise_result = appraise_result;
    }
}
