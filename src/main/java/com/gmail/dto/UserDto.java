package com.gmail.dto;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by Space on 17.05.2019.
 */
public interface UserDto {
    void save(User user);

    User getById(Long id);

    List<User> getByName(String name);

    List<User> getByBirthdayDate(LocalDate birthdayDate);

    void deleteUser(User userEntity);

    void deleteById(Long id);

    List<User> getAll();
}
