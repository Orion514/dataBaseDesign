package com.edu.domain.project;

public class Participate {
    private String postgraduate_id;
    private String project_id;
    private String time;
    private String undertake;
    private float funds;

    public void setPostgraduate_id(String postgraduate_id) {
        this.postgraduate_id = postgraduate_id;
    }

    public String getPostgraduate_id() {
        return postgraduate_id;
    }

    public void setProject_id(String project_id) {
        this.project_id = project_id;
    }

    public String getProject_id() {
        return project_id;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTime() {
        return time;
    }

    public void setUndertake(String undertake) {
        this.undertake = undertake;
    }

    public String getUndertake() {
        return undertake;
    }

    public void setFunds(float funds) {
        this.funds = funds;
    }

    public float getFunds() {
        return funds;
    }
}
