package com.gmail.service;


import com.gmail.exceptions.UserNotFoundException;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by Space on 09.05.2019.
 */
public interface UserService {
    void save(User user);

    User getById(Long id) throws UserNotFoundException;

    List<User> getByName(String name);

    List<User> getByBirthdayDate(LocalDate birthdayDate);

    void deleteUser(User user);

    void deleteById(Long id);

    List<User> getAll();
}
