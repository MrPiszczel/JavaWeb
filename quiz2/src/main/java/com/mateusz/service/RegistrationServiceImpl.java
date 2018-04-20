package com.mateusz.service;

import com.mateusz.model.User;
import com.mateusz.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationServiceImpl {

    @Autowired
    private UserRepository userRepository;

    public RegistrationServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean save(User user, String login, String password, String password2){

        if(login.length() > 5 && login.length() < 10
                && password.length() >5 && password.length() < 15
                && password.equals(password2)) {
            userRepository.save(user);
            return true;
        }else if(login.length() <5 || login.length() > 10
                ||  password.length() < 5 || password.length() > 15
                || !password.equals(password2)){
            return false;
        }
        return true;
    }
}