package com.edu.domain.assistant;

/**
 * Course : 课程表
 */
public class Course {
    public int cid;
    public String name;
    public String property;
    public String teach_object;
    public int subject_id;
    public int hour;

    public Course() {
    }

    public Course(int cid, String name, String property, String teach_object, int subject_id, int hour) {
        this.cid = cid;
        this.name = name;
        this.property = property;
        this.teach_object = teach_object;
        this.subject_id = subject_id;
        this.hour = hour;
    }

    @Override
    public String toString() {
        return "Course{" +
                "cid=" + cid +
                ", name='" + name + '\'' +
                ", property='" + property + '\'' +
                ", teach_object='" + teach_object + '\'' +
                ", subject_id=" + subject_id +
                ", hour=" + hour +
                '}';
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getTeach_object() {
        return teach_object;
    }

    public void setTeach_object(String teach_object) {
        this.teach_object = teach_object;
    }

    public int getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(int subject_id) {
        this.subject_id = subject_id;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }
}
