package com.informatics.crud.service;

import com.informatics.crud.entity.LoginEntity;
import com.informatics.crud.entity.UserEntity;
import com.informatics.crud.repository.LoginRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Ali Alavi
 */

@Service
public class LoginService {

    @Autowired
    private LoginRepository repository;


    @Transactional
    public LoginEntity save(String userName,String password){
        LoginEntity entity=new LoginEntity();
        entity.setUserName(userName);
        entity.setPassword(password);
        return repository.save(entity);
    }


    public LoginEntity get(String userName){
        return repository.findByUserName(userName);
    }




}
