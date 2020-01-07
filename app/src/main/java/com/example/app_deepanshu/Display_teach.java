package com.example.app_deepanshu;

import java.util.ArrayList;

public class Display_teach {

    private Integer school_id;
    private String aadhar;
    private String name;
    private String email;
    private String address;
    private Integer mobile_number;
    private String state;
    private Integer id;

    public Display_teach(Integer school_id, String aadhar, String name, String email, String address, Integer mobile_number, String state, Integer id) {
        this.school_id = school_id;
        this.aadhar = aadhar;
        this.name = name;
        this.email = email;
        this.address = address;
        this.mobile_number = mobile_number;
        this.state = state;
        this.id = id;
    }

    public Integer getSchool_id() {
        return school_id;
    }

    public void setSchool_id(Integer school_id) {
        this.school_id = school_id;
    }

    public String getAadhar() {
        return aadhar;
    }

    public void setAadhar(String aadhar) {
        this.aadhar = aadhar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getMobile_number() {
        return mobile_number;
    }

    public void setMobile_number(Integer mobile_number) {
        this.mobile_number = mobile_number;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
