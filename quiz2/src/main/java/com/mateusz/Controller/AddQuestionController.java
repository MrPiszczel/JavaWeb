package com.mateusz.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AddQuestionController {

    @RequestMapping("/login/addQuestion")
    public String addQuestion(){
        return "addQuestion";
    }

    //To-Do save question
}