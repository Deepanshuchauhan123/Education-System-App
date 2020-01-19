package com.example.app_deepanshu;

public class ActivitiesModel {

    private String notice;
    private String venue;
    private String teacher;
    private String student;


    public ActivitiesModel(String notice, String venue, String teacher, String student) {
        this.notice = notice;
        this.venue = venue;
        this.teacher = teacher;
        this.student = student;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getStudent() {
        return student;
    }

    public void setStudent(String student) {
        this.student = student;
    }
}
