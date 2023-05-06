package com.informatics.crud.service;


import com.informatics.crud.common.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Ali Alavi
 */

@Service
public class CommonService {

    @Autowired
    private JwtProvider tokenCreation;


    public String getToken(String userName){
        return tokenCreation.generateToken(userName);
    }

}
