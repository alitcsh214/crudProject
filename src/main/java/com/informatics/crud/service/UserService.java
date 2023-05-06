package com.informatics.crud.service;

import com.informatics.crud.entity.UserEntity;
import com.informatics.crud.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.Optional;

/**
 * @author Ali Alavi
 */

@Service
public class UserService {

    @Autowired
    private UserRepository repository;


    @Transactional
    public UserEntity save(UserEntity user){
        user.setCreateDate(LocalDate.now().toString());
        user.setStatus(false);
        return repository.save(user);
    }


    public Page<UserEntity> getAll(Pageable pageable){
        return repository.findAll(pageable);
    }


    public UserEntity getUser(String nationalCode){
        return repository.findByNationalCode(nationalCode);
    }


    @Transactional
    public UserEntity update(UserEntity user){
        Optional<UserEntity> userEntity = repository.findById(user.getId());
        userEntity.get().setName(user.getName());
        userEntity.get().setFamily(user.getFamily());
        userEntity.get().setAge(user.getAge());
        userEntity.get().setNationalCode(user.getNationalCode());
        userEntity.get().setStartDate(user.getStartDate());
        userEntity.get().setExpDate(user.getExpDate());
        userEntity.get().setGender(user.getGender());
        return repository.save(userEntity.get());
    }


    @Transactional
    public Boolean changeStatus(Long id , Boolean status){
        Optional<UserEntity> userEntity = repository.findById(id);
        userEntity.get().setStatus(status);
        return repository.save(userEntity.get()).getStatus();
    }


    public void deleteUser(Long id){
        repository.deleteById(id);
    }


    public void deleteAll(){
        repository.deleteAll();
    }

}
