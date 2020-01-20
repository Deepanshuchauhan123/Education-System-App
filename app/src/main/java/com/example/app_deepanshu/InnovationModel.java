package com.example.app_deepanshu;

public class InnovationModel {

    private String name,clas,section,school,district,state
            ,probTitle,probDesc,solTitle,solDesc,technique;

    public InnovationModel() {
    }

    public InnovationModel(String name, String clas, String section, String school, String district, String state, String probTitle, String probDesc, String solTitle, String solDesc, String technique) {
        this.name = name;
        this.clas = clas;
        this.section = section;
        this.school = school;
        this.district = district;
        this.state = state;
        this.probTitle = probTitle;
        this.probDesc = probDesc;
        this.solTitle = solTitle;
        this.solDesc = solDesc;
        this.technique = technique;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClas() {
        return clas;
    }

    public void setClas(String clas) {
        this.clas = clas;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getProbTitle() {
        return probTitle;
    }

    public void setProbTitle(String probTitle) {
        this.probTitle = probTitle;
    }

    public String getProbDesc() {
        return probDesc;
    }

    public void setProbDesc(String probDesc) {
        this.probDesc = probDesc;
    }

    public String getSolTitle() {
        return solTitle;
    }

    public void setSolTitle(String solTitle) {
        this.solTitle = solTitle;
    }

    public String getSolDesc() {
        return solDesc;
    }

    public void setSolDesc(String solDesc) {
        this.solDesc = solDesc;
    }

    public String getTechnique() {
        return technique;
    }

    public void setTechnique(String technique) {
        this.technique = technique;
    }
}
