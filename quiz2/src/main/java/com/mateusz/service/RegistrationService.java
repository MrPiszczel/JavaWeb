package com.mateusz.service;

import com.mateusz.model.User;

import java.util.List;

public interface RegistrationService {
    List<User> findAll();
    User create(User user);

    public User findUserByLogin(String login);
    public void saveUser(User user);

}
