package com.mateusz.service;

import com.mateusz.model.User;
import com.mateusz.model.Role;
import com.mateusz.repository.RoleRepository;
import com.mateusz.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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
    public List<User> findAllUsers() {

        List<User> user = userRepository.findAllUsers();

        return user;
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

    @Override
    public int findUserPoints(String name){
        int number=0;

        List<User> user = userRepository.findAllUsers();

        for(User u: user){
            if(u.getUsername().equals(name)){
                number = u.getPoints();
                return number;
            }
        }
        return number;
    }

}