package com.informatics.crud.service;

import com.informatics.crud.entity.UserFieldEntity;
import com.informatics.crud.repository.UserFieldRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Ali Alavi
 */

@Service
public class UserSportFieldService {

    @Autowired
    private UserFieldRepository repository;


    @Transactional
    public UserFieldEntity save(UserFieldEntity entity){
        return repository.save(entity);
    }



    public void delete(long id){
        repository.deleteById(id);
    }



}
