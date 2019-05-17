package com.gmail.repository;


import com.gmail.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by Space on 09.05.2019.
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    List<UserEntity> findUsersByName(String userName);

    List<UserEntity> findUsersByBirthdayDate(LocalDate birthdayDate);
}
