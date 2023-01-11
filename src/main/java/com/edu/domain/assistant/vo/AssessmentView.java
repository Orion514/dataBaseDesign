package com.edu.domain.assistant.vo;

import java.sql.Date;

/**
 * AssessmentAll : 助教评定表（视图）
 */
public class AssessmentView {
    private String student_name;
    private String student_id;
    private String course_name;
    private int course_student_num;
    private String subject_name;
    private String course_property;
    private String course_object;
    private String teacher_name;
    private String teach_time;
    private String work_statement;
    private Date statement_time;
    private String appraise;
    private Date appraise_time;
    private String appraise_result;

    public AssessmentView() {
    }

    public AssessmentView(String student_name, String student_id, String course_name, int course_student_num,
                         String subject_name, String course_property, String course_object, String teacher_name,
                         String teach_time, String work_statement, Date statement_time, String appraise,
                         Date appraise_time, String appraise_result) {
        this.student_name = student_name;
        this.student_id = student_id;
        this.course_name = course_name;
        this.course_student_num = course_student_num;
        this.subject_name = subject_name;
        this.course_property = course_property;
        this.course_object = course_object;
        this.teacher_name = teacher_name;
        this.teach_time = teach_time;
        this.work_statement = work_statement;
        this.statement_time = statement_time;
        this.appraise = appraise;
        this.appraise_time = appraise_time;
        this.appraise_result = appraise_result;
    }

    @Override
    public String toString() {
        return "AssessmentView{" +
                "student_name='" + student_name + '\'' +
                ", student_id='" + student_id + '\'' +
                ", course_name='" + course_name + '\'' +
                ", course_student_num='" + course_student_num + '\'' +
                ", subject_name='" + subject_name + '\'' +
                ", course_property='" + course_property + '\'' +
                ", course_object='" + course_object + '\'' +
                ", teacher_name='" + teacher_name + '\'' +
                ", teach_time='" + teach_time + '\'' +
                ", work_statement='" + work_statement + '\'' +
                ", statement_time=" + statement_time +
                ", appraise='" + appraise + '\'' +
                ", appraise_time=" + appraise_time +
                ", appraise_result='" + appraise_result + '\'' +
                '}';
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public int getCourse_student_num() {
        return course_student_num;
    }

    public void setCourse_student_num(int course_student_num) {
        this.course_student_num = course_student_num;
    }

    public String getSubject_name() {
        return subject_name;
    }

    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
    }

    public String getCourse_property() {
        return course_property;
    }

    public void setCourse_property(String course_property) {
        this.course_property = course_property;
    }

    public String getCourse_object() {
        return course_object;
    }

    public void setCourse_object(String course_object) {
        this.course_object = course_object;
    }

    public String getTeacher_name() {
        return teacher_name;
    }

    public void setTeacher_name(String teacher_name) {
        this.teacher_name = teacher_name;
    }

    public String getTeach_time() {
        return teach_time;
    }

    public void setTeach_time(String teach_time) {
        this.teach_time = teach_time;
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

    public String getAppraise() {
        return appraise;
    }

    public void setAppraise(String appraise) {
        this.appraise = appraise;
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
