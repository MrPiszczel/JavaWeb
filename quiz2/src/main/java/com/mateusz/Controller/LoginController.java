package com.mateusz.Controller;

import com.mateusz.model.Question;

import com.mateusz.model.User;
import com.mateusz.repository.UserRepository;
import com.mateusz.service.QuestionService;
import com.mateusz.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.List;

@Controller
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private QuestionService questionService;

    @Autowired
    private RegistrationService registrationService;

    @RequestMapping("/main")
    public String main(Model model, HttpServletRequest request){



        List<Long> idQuestion = questionService.findLatest2();
        model.addAttribute("idQuestion", idQuestion);

        List<String> nameQuestion = questionService.findNameQuestions();
        model.addAttribute("nameQuestion", nameQuestion);

        List<Question> questions = questionService.findAllQuestions();
        model.addAttribute("questions", questions);

        List<User> users = registrationService.findAllUsers();

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        model.addAttribute("username", name);
        int point = registrationService.findUserPoints(name);
        model.addAttribute("points", point);

        String trueAnswer = request.getParameter("trueAnswer");
        String question = request.getParameter("question");

        for(Question q: questions){

            if(q.getQuestion().equals(question) && q.getTrueAnswer().equals(trueAnswer)){
                for(User u: users){
                    if(u.getUsername().equals(name)){
                        int points = u.getPoints() + 2;

                        boolean answerT = true;
                        model.addAttribute("answer", answerT);

                        u.setPoints(points);
                        userRepository.save(u);

                    }
                }

            }

        }



        return "main";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

}
