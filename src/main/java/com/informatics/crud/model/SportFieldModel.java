package com.informatics.crud.model;

import com.informatics.crud.common.SportField;

/**
 * @author Ali Alavi
 */

public class SportFieldModel {

    private Long id;
    private Long userId;
    private SportField sportField;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
