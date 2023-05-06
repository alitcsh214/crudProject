package com.informatics.crud;

import com.informatics.crud.entity.UserEntity;
import com.informatics.crud.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Ali Alavi
 */

@SpringBootTest
public class UserTests {

    @Autowired
    private UserService userService;


    @Test
    public void testSave(){
        UserEntity userEntity=createUserEntity();
        UserEntity response=addUser(userEntity);
        userEntity.setId(response.getId());
        assertEquals(response,userEntity);
    }


    @Test
    public void testDelete(){
        addUser(createUserEntity());
        try {
            userService.deleteUser(1L);
        }catch (Exception e){
            fail("error");
        }

    }


    @Test
    public void testGetUser(){
        addUser(createUserEntity());
        try {
            UserEntity res=userService.getUser("1990033210");
            assertNotNull(res);
        }catch (Exception e){
            fail("error");
        }

    }


    @Test
    public void testGetAllUser(){
        addUser(createUserEntity());
        Pageable pageable = PageRequest.of(0, 10, Sort.by(Sort.Order.asc("name"), Sort.Order.desc("id")));
        try {
            Page<UserEntity> res=userService.getAll(pageable);
            assertNotNull(res.getContent());
        }catch (Exception e){
            fail("error");
        }

    }


    @Test
    public void testUpdateUser(){
        UserEntity res=addUser(createUserEntity());

        try {
            res.setName("reza");
            UserEntity update=userService.update(res);
            assertNotNull(update);
        }catch (Exception e){
            fail("error");
        }

    }


    @Test
    public void testChangeStatusUser(){
        UserEntity res=addUser(createUserEntity());

        try {
            Boolean newStatus=false;
            Boolean status=userService.changeStatus(res.getId(),newStatus);
            assertEquals(status,newStatus);
        }catch (Exception e){
            fail("error");
        }

    }





    private UserEntity addUser(UserEntity user){
        return userService.save(user);
    }


    private UserEntity createUserEntity(){
        UserEntity entity=new UserEntity();
        entity.setName("ali");
        entity.setFamily("alavi");
        entity.setNationalCode("1990033210");
        entity.setAge(33);
        entity.setCreateDate("2023-5-6");
        entity.setStartDate("1402/03/01");
        entity.setExpDate("1402/04/01");
        entity.setStatus(true);
        entity.setGender(true);
        return entity;
    }


}
