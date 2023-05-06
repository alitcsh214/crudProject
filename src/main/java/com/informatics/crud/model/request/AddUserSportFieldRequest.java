package com.informatics.crud.model.request;


import com.informatics.crud.common.SportField;

/**
 * @author Ali Alavi
 */

public class AddUserSportFieldRequest {


    private Long userId;
    private SportField sportField;



    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public SportField getSportField() {
        return sportField;
    }

    public void setSportField(SportField sportField) {
        this.sportField = sportField;
    }
}
