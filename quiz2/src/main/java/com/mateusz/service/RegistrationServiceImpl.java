package com.mateusz.service;

import com.mateusz.model.User;
import com.mateusz.model.Role;
import com.mateusz.repository.RoleRepository;
import com.mateusz.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Service
public class RegistrationServiceImpl implements RegistrationService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;


    public boolean save(User user, String login, String password, String password2, Role role){

        if(login.length() > 5 && login.length() < 10
                && password.length() >5 && password.length() < 15
                && password.equals(password2)) {


            userRepository.save(user);
            roleRepository.save(role);
            return true;
        }else if(login.length() <5 || login.length() > 10
                ||  password.length() < 5 || password.length() > 15
                || !password.equals(password2)){
            return false;
        }
        return true;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User create(User user) {
        return null;
    }

    @Override
    public User findUserByLogin(String login) {
        return null;
    }

    @Override
    public void saveUser(User user) {

    }
}