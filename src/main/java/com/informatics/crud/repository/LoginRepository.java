package com.informatics.crud.repository;

import com.informatics.crud.entity.LoginEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Ali Alavi
 */

@Repository
public interface LoginRepository extends JpaRepository<LoginEntity,Long> {
    LoginEntity findByUserName(String Username);
}
