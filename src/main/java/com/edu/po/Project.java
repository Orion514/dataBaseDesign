package com.edu.po;

public class Project {
    private String identifier;
    private String type;
    private String name;
    private String tutor_id;

    private float funds;

    private float surplus_funds;
    public void setIdentifier(String identifier){
        this.identifier=identifier;
    }
    public String getIdentifier() {
        return identifier;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setTutor_id(String tutor_id) {
        this.tutor_id = tutor_id;
    }

    public String getTutor_id() {
        return tutor_id;
    }

    public void setFunds(float funds) {
        this.funds = funds;
    }

    public float getFunds() {
        return funds;
    }

    public float getSurplus_funds() {
        return surplus_funds;
    }

    public void setSurplus_funds(float surplus_funds) {
        this.surplus_funds = surplus_funds;
    }
}
