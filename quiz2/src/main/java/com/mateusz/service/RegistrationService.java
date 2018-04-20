package com.mateusz.service;

import com.mateusz.model.User;

import java.util.List;

public interface RegistrationService {
    List<User> findAll();
    User findById(Long id);
    User create(User user);
}
