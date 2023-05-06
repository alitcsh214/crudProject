package com.informatics.crud.model;

/**
 * @author Ali Alavi
 */

public class LoginResponse {

    private Long id;
    private String token;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
