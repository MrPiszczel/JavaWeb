package com.mateusz.Controller;

import com.mateusz.model.Question;

import com.mateusz.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class LoginController {

    @Autowired
    private QuestionService questionService;

    @RequestMapping("/main")
    public String main(Model model){

        List<Long> idQuestion = questionService.findLatest2();
        model.addAttribute("idQuestion", idQuestion);

        List<String> nameQuestion = questionService.findNameQuestions();
        model.addAttribute("nameQuestion", nameQuestion);

        List<Question> questions = questionService.findAllQuestions();
        model.addAttribute("questions", questions);

        return "main";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

//    @RequestMapping(method = RequestMethod.POST,value = "/login")
//    public String MainPage(Model model, HttpServletRequest request) { // @PathVariable("id") Long id
//
//        String login = request.getParameter("login");
//        String password = request.getParameter("password");
//
//        List<Long> idQuestion = questionService.findLatest2();
//        model.addAttribute("idQuestion", idQuestion);
//
//        List<String> nameQuestion = questionService.findNameQuestions();
//        model.addAttribute("nameQuestion", nameQuestion);
//
//        List<Question> questions = questionService.findAllQuestions();
//        model.addAttribute("questions", questions);
//
//        if(!loginService.login(login, password, request)){
//            return "loginError";
//        }
//
//        return "main";
//    }

}
