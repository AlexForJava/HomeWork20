package com.gmail.dto;

import com.gmail.entities.UserEntity;
import com.gmail.exceptions.UserNotFoundException;
import com.gmail.service.UserService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Space on 17.05.2019.
 */
@Log4j
@Component
public class UserDtoImpl implements UserDto {
    @Autowired
    private UserService service;

    @Autowired
    private UserEntity userEntity;

    public void save(User user) {
        userEntity.setEmail(user.getEmail());
        userEntity.setBirthdayDate(user.getBirthdayDate());
        userEntity.setName(user.getName());
        service.save(userEntity);
    }

    @Override
    public User getById(Long id) {
        UserEntity userEntityById = null;
        try {
            userEntityById = service.getById(id);
        } catch (UserNotFoundException e) {
            log.error("UserDao ", e);
        }
        return (userEntityById != null) ? buildUser(userEntityById) : new User();
    }

    @Override
    public List<User> getByName(String name) {
        return service.getByName(name)
                .stream()
                .map(this::buildUser)
                .collect(Collectors.toList());
    }

    @Override
    public List<User> getByBirthdayDate(LocalDate birthdayDate) {
        return service.getByBirthdayDate(birthdayDate)
                .stream()
                .map(this::buildUser)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteUser(User user) {
        service.deleteUser(buildEntity(user));
    }

    @Override
    public void deleteById(Long id) {
        service.deleteById(id);
    }

    @Override
    public List<User> getAll() {
        return service.getAll()
                .stream()
                .map(this::buildUser)
                .collect(Collectors.toList());
    }

    private User buildUser(UserEntity entity) {
        return new User()
                .setId(entity.getId())
                .setName(entity.getName())
                .setRandom(entity.getRandom())
                .setBirthdayDate(entity.getBirthdayDate())
                .setEmail(entity.getEmail());
    }

    private UserEntity buildEntity(User user) {
        UserEntity entity = new UserEntity();
        entity.setId(user.getId());
        entity.setName(user.getName());
        entity.setRandom(user.getRandom());
        entity.setEmail(user.getEmail());
        return entity;
    }
}
