package com.informatics.crud.common;

import com.informatics.crud.entity.UserEntity;
import com.informatics.crud.entity.UserFieldEntity;
import com.informatics.crud.model.SportFieldModel;
import com.informatics.crud.model.request.AddUserRequest;
import com.informatics.crud.model.request.AddUserSportFieldRequest;
import com.informatics.crud.model.response.AddUserResponse;
import java.util.stream.Collectors;

/**
 * @author Ali Alavi
 */

public class Translator {


    public static UserEntity translate (AddUserRequest request) {
       UserEntity user=new UserEntity();
       user.setName(request.getName());
       user.setFamily(request.getFamily());
       user.setAge(request.getAge());
       user.setNationalCode(request.getNationalCode());
       user.setStartDate(request.getStartDate());
       user.setExpDate(request.getExpDate());
       user.setGender(request.getGender());
        return user;
   }

    public static AddUserResponse translate (UserEntity entity) {
        AddUserResponse response=new AddUserResponse();
        response.setId(entity.getId());
        response.setName(entity.getName());
        response.setFamily(entity.getFamily());
        response.setAge(entity.getAge());
        response.setNationalCode(entity.getNationalCode());
        response.setCreateDate(entity.getCreateDate());
        response.setStartDate(entity.getStartDate());
        response.setExpDate(entity.getExpDate());
        response.setGender(entity.getGender());
        response.setStatus(entity.getStatus());
        if(entity.getList()!=null)
        response.setSportFields(entity.getList().stream().map(Translator::translate).collect(Collectors.toList()));
        return response;
    }

    public static SportFieldModel translate (UserFieldEntity entity){
        SportFieldModel model=new SportFieldModel();
        model.setId(entity.getId());
        model.setUserId(entity.getUserId());
        model.setSportField(entity.getSportField());
        return model;
    }

    public static UserFieldEntity translate (AddUserSportFieldRequest request){
        UserFieldEntity entity=new UserFieldEntity();
        entity.setUserId(request.getUserId());
        entity.setSportField(request.getSportField());
        return entity;
    }

}
