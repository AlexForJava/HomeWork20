package com.gmail.service;

import com.gmail.entities.UserEntity;
import com.gmail.exceptions.UserNotFoundException;
import com.gmail.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Space on 09.05.2019.
 */
@Log4j
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private UserEntity userEntity;

    @Override
    public void save(User user) {
        userEntity.setBirthdayDate(user.getBirthdayDate());
        userEntity.setEmail(user.getEmail());
        userEntity.setName(user.getName());
        userRepository.save(userEntity);
    }

    @Override
    public User getById(Long id) throws UserNotFoundException {
        return buildUser(userRepository.findById(id).orElseThrow(UserNotFoundException::new));
    }

    @Override
    public List<User> getByName(String name) {
        return userRepository.findUsersByName(name)
                .stream()
                .map(this::buildUser)
                .collect(Collectors.toList());
    }

    @Override
    public List<User> getByBirthdayDate(LocalDate birthdayDate) {
        return userRepository.findUsersByBirthdayDate(birthdayDate)
                .stream()
                .map(this::buildUser)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteUser(User user) {
        userRepository.delete(buildEntity(user));
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll()
                .stream()
                .map(this::buildUser)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
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
