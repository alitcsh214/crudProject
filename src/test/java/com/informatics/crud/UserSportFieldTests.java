package com.informatics.crud;


import com.informatics.crud.common.SportField;
import com.informatics.crud.entity.UserEntity;
import com.informatics.crud.entity.UserFieldEntity;
import com.informatics.crud.service.UserService;
import com.informatics.crud.service.UserSportFieldService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Ali Alavi
 */

@SpringBootTest
class UserSportFieldTests {


    @Autowired
    private UserSportFieldService service;

    @Autowired
    private UserService userService;




    @Test
    public void testSaveSportField(){
        UserFieldEntity entity=new UserFieldEntity();
        entity.setUserId(1L);
        entity.setSportField(SportField.Bodybuilding);
        addUser();
        assertEquals(addSportField(entity),entity);
    }


    @Test
    public void testDelete(){
        UserFieldEntity entity=new UserFieldEntity();
        entity.setUserId(1L);
        entity.setSportField(SportField.Bodybuilding);
        addUser();
        try {
            service.delete(addSportField(entity).getId());
        }catch (Exception e){
            fail("error");
        }

    }





    private void addUser(){
        UserEntity entity=new UserEntity();
        entity.setName("ali");
        entity.setFamily("alavi");
        entity.setNationalCode("199003310");
        entity.setAge(33);
        entity.setCreateDate("2023-5-6");
        entity.setStartDate("1402/03/01");
        entity.setExpDate("1402/04/01");
        entity.setStatus(true);
        entity.setGender(true);
        userService.save(entity);
    }


    private UserFieldEntity addSportField(UserFieldEntity entity){
        return service.save(entity);
    }

}
