package com.mateusz.Controller;

import com.mateusz.model.Role;
import com.mateusz.model.User;
import com.mateusz.service.RegistrationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class RegistrationController {

    @Autowired
    private RegistrationServiceImpl registrationServiceImpl;

    @RequestMapping("/join")
    public String join(){
        return "registration";
    }

    @RequestMapping("/registration")
    public String registration(Model model, HttpServletRequest request){

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String password2 = request.getParameter("password2");

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        Role role = new Role();
        role.setRole("ROLE_USER");
        role.setUser(user);


        if(!registrationServiceImpl.save(user, username, password, password2, role)){
          return "loginError";
        }

        return "index";
    }
}
