package com.mateusz.Controller;

import com.mateusz.model.User;
import com.mateusz.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class RegistrationController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/join")
    public String join(){
        return "registration";
    }

    @RequestMapping("/registration")
    public String registration(Model model, HttpServletRequest request){

        User user = new User();

        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String password2 = request.getParameter("password2");

        if(login.length() > 5 && login.length() < 10
                && password.length() >5 && password.length() < 15
                && password.equals(password2)) {
            user.setLogin(login);
            user.setPassword(password);
            user.setPassword2(password2);
            userRepository.save(user);
        }else if(login.length() <5 || login.length() > 10
                ||  password.length() < 5 || password.length() > 15
                || !password.equals(password2)){
            return "loginError";
        }


        return "index";
    }
}
