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
public class IndexController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/")
    public String index(Model model, HttpServletRequest request) {


        return "index";
    }

    
}
