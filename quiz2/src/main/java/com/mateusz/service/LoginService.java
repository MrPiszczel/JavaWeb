package com.mateusz.service;

import com.mateusz.model.User;
import com.mateusz.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class LoginService {

    @Autowired
    private UserRepository userRepository;

    public Boolean login(String login, String password,  HttpServletRequest request){

        List<User> users = userRepository.findAllUserName();

        for (User loginUser: users) {
            if (login.equals(loginUser.getLogin()) && password.equals(loginUser.getPassword())){
                request.setAttribute("userLogin", login);

                return true;
            }
        }
        return false;
    }

}
