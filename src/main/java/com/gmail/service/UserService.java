package com.gmail.service;


import com.gmail.entities.UserEntity;
import com.gmail.exceptions.UserNotFoundException;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by Space on 09.05.2019.
 */
public interface UserService {
    void save(UserEntity userEntity);

    UserEntity getById(Long id) throws UserNotFoundException;

    List<UserEntity> getByName(String name);

    List<UserEntity> getByBirthdayDate(LocalDate birthdayDate);

    void deleteUser(UserEntity userEntity);

    void deleteById(Long id);

    List<UserEntity> getAll();
}
