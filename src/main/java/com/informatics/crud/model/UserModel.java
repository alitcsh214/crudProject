package com.informatics.crud.model;

import java.util.List;

/**
 * @author Ali Alavi
 */

public class UserModel {

    private Long id;
    private String name;
    private String family;
    private Integer age;
    private String nationalCode;
    private String createDate;
    private String startDate;
    private String expDate;
    private Boolean gender;
    private Boolean status;
    private List<SportFieldModel> sportFields;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public List<SportFieldModel> getSportFields() {
        return sportFields;
    }

    public void setSportFields(List<SportFieldModel> sportFields) {
        this.sportFields = sportFields;
    }
}
