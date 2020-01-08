package com.example.app_deepanshu;

public class Schemes_Model {
    private String select;
    private String type;
    private String cat;
    private String gender;
    private String level;
    private String beneficiary;
    private String org;
    private String title;
    private String about;
    private String desc;
    private String link;

    public Schemes_Model(String select, String type, String cat, String gender, String level, String beneficiary, String org, String title, String about, String desc, String link) {
        this.select = select;
        this.type = type;
        this.cat = cat;
        this.gender = gender;
        this.level = level;
        this.beneficiary = beneficiary;
        this.org = org;
        this.title = title;
        this.about = about;
        this.desc = desc;
        this.link = link;
    }

    public String getSelect() {
        return select;
    }

    public void setSelect(String select) {
        this.select = select;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getBeneficiary() {
        return beneficiary;
    }

    public void setBeneficiary(String beneficiary) {
        this.beneficiary = beneficiary;
    }

    public String getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org = org;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
