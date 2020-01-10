package com.example.app_deepanshu;

public class ReportModel {
    private String name;
    private Integer aadhar;
    private String clas;
    private String subject;
    private Integer attended_classes;
    private Integer total_classes;
    private String suggestions;
    private String behaviour;
    private String date;

    public ReportModel(String name, Integer aadhar, String clas, String subject, Integer attended_classes, Integer total_classes, String suggestions, String behaviour, String date) {
        this.name = name;
        this.aadhar = aadhar;
        this.clas = clas;
        this.subject = subject;
        this.attended_classes = attended_classes;
        this.total_classes = total_classes;
        this.suggestions = suggestions;
        this.behaviour = behaviour;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAadhar() {
        return aadhar;
    }

    public void setAadhar(Integer aadhar) {
        this.aadhar = aadhar;
    }

    public String getClas() {
        return clas;
    }

    public void setClas(String clas) {
        this.clas = clas;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Integer getAttended_classes() {
        return attended_classes;
    }

    public void setAttended_classes(Integer attended_classes) {
        this.attended_classes = attended_classes;
    }

    public Integer getTotal_classes() {
        return total_classes;
    }

    public void setTotal_classes(Integer total_classes) {
        this.total_classes = total_classes;
    }

    public String getSuggestions() {
        return suggestions;
    }

    public void setSuggestions(String suggestions) {
        this.suggestions = suggestions;
    }

    public String getBehaviour() {
        return behaviour;
    }

    public void setBehaviour(String behaviour) {
        this.behaviour = behaviour;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
