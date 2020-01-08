package com.example.app_deepanshu;

public class Subject_Model_Teach {

    private String stream;
    private String batch;
    private String clas;
    private String subject;

    public Subject_Model_Teach(String stream, String batch, String clas, String subject) {
        this.stream = stream;
        this.batch = batch;
        this.clas = clas;
        this.subject = subject;
    }

    public String getStream() {
        return stream;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
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
}
