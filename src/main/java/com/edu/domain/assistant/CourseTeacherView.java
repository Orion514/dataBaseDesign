package com.edu.domain.assistant;

/**
 * CourseTeacherView : 课程教师视图类
 */
public class CourseTeacherView {
    public int id;
    public String course_name;
    public String course_property;
    public String course_subject_id;
    public String course_subject_name;
    public int course_hour;
    public String course_teach_object;
    public String teacher_id;
    public String teacher_name;
    public String teacher_user_id;
    public String teach_time;
    public int teach_student_num;


    public CourseTeacherView() {
    }

    public CourseTeacherView(int id, String course_name, String course_property, String course_subject_id, String course_subject_name,
                             int course_hour, String course_teach_object, String teacher_id, String teacher_name, String teacher_user_id,
                             String teach_time, int teach_student_num) {
        this.id = id;
        this.course_name = course_name;
        this.course_property = course_property;
        this.course_subject_id = course_subject_id;
        this.course_subject_name = course_subject_name;
        this.course_hour = course_hour;
        this.course_teach_object = course_teach_object;
        this.teacher_id = teacher_id;
        this.teacher_name = teacher_name;
        this.teacher_user_id = teacher_user_id;
        this.teach_time = teach_time;
        this.teach_student_num = teach_student_num;
    }

    @Override
    public String toString() {
        return "CourseTeacherView{" +
                "id=" + id +
                ", course_name='" + course_name + '\'' +
                ", course_property='" + course_property + '\'' +
                ", course_subject_id='" + course_subject_id + '\'' +
                ", course_subject_name='" + course_subject_name + '\'' +
                ", course_hour=" + course_hour +
                ", course_teach_object='" + course_teach_object + '\'' +
                ", teacher_id='" + teacher_id + '\'' +
                ", teacher_name='" + teacher_name + '\'' +
                ", teacher_user_id='" + teacher_user_id + '\'' +
                ", teach_time='" + teach_time + '\'' +
                ", teach_student_num=" + teach_student_num +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getCourse_property() {
        return course_property;
    }

    public void setCourse_property(String course_property) {
        this.course_property = course_property;
    }

    public String getCourse_subject_id() {
        return course_subject_id;
    }

    public void setCourse_subject_id(String course_subject_id) {
        this.course_subject_id = course_subject_id;
    }

    public String getCourse_subject_name() {
        return course_subject_name;
    }

    public void setCourse_subject_name(String course_subject_name) {
        this.course_subject_name = course_subject_name;
    }

    public int getCourse_hour() {
        return course_hour;
    }

    public void setCourse_hour(int course_hour) {
        this.course_hour = course_hour;
    }

    public String getCourse_teach_object() {
        return course_teach_object;
    }

    public void setCourse_teach_object(String course_teach_object) {
        this.course_teach_object = course_teach_object;
    }

    public String getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(String teacher_id) {
        this.teacher_id = teacher_id;
    }

    public String getTeacher_name() {
        return teacher_name;
    }

    public void setTeacher_name(String teacher_name) {
        this.teacher_name = teacher_name;
    }

    public String getTeacher_user_id() {
        return teacher_user_id;
    }

    public void setTeacher_user_id(String teacher_user_id) {
        this.teacher_user_id = teacher_user_id;
    }

    public String getTeach_time() {
        return teach_time;
    }

    public void setTeach_time(String teach_time) {
        this.teach_time = teach_time;
    }

    public int getTeach_student_num() {
        return teach_student_num;
    }

    public void setTeach_student_num(int teach_student_num) {
        this.teach_student_num = teach_student_num;
    }
}
