package com.edu.domain.common;

public class Subject {
    private String id;
    private String name;
    private String project_funds;
    private int academic_exchange_count;
    private int aspiration_count;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProject_funds() {
        return project_funds;
    }

    public void setProject_funds(String project_funds) {
        this.project_funds = project_funds;
    }

    public int getAcademic_exchange_count() {
        return academic_exchange_count;
    }

    public void setAcademic_exchange_count(int academic_exchange_count) {
        this.academic_exchange_count = academic_exchange_count;
    }

    public int getAspiration_count() {
        return aspiration_count;
    }

    public void setAspiration_count(int aspiration_count) {
        this.aspiration_count = aspiration_count;
    }
}
