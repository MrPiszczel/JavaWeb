package com.mateusz.service;

import com.mateusz.model.User;

import java.util.List;

public interface RegistrationService {
    List<User> findAllUsers();
    User create(User user);

    public User findUserByLogin(String login);
    public void saveUser(User user);

    int findUserPoints(String name);
}
