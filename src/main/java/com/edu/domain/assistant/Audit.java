package com.edu.domain.assistant;

public class Audit {
    private int id;
    private String sno_id;
    private String cid;
    private String audit_state;
    private int choice;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSno_id() {
        return sno_id;
    }

    public void setSno_id(String sno_id) {
        this.sno_id = sno_id;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getAudit_state() {
        return audit_state;
    }

    public void setAudit_state(String audit_state) {
        this.audit_state = audit_state;
    }

    public int getChoice() {
        return choice;
    }

    public void setChoice(int choice) {
        this.choice = choice;
    }
}
