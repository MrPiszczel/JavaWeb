package com.mateusz.Controller;

import com.mateusz.model.User;
import com.mateusz.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/login")
    public String MainPage(Model model, HttpServletRequest request) {
        List<User> users = userRepository.findAllUserName();

        String login = request.getParameter("login");
        String password = request.getParameter("password");

        for (User loginUser: users) {
            if (login.equals(loginUser.getLogin())){
                request.setAttribute("userLogin", login);

                return "main";
            }
        }

        return "loginError";
    }
}
