package com.informatics.crud.repository;

import com.informatics.crud.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Ali Alavi
 */

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {

    UserEntity findByNationalCode(String nationalCode);
}
