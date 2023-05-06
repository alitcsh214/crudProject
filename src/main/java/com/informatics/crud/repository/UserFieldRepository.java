package com.informatics.crud.repository;

import com.informatics.crud.entity.UserFieldEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * @author Ali Alavi
 */

@Repository
public interface UserFieldRepository extends JpaRepository<UserFieldEntity,Long> {

    List<UserFieldEntity> findUserFieldEntityByUserId(long id);
}
