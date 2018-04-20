package com.mateusz.Controller;

import com.mateusz.model.Question;
import com.mateusz.model.User;
import com.mateusz.repository.UserRepository;
import com.mateusz.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

//@RequestMapping("login")
@Controller
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private QuestionService questionService;

    @RequestMapping("/login")
    public String MainPage(Model model, HttpServletRequest request) { // @PathVariable("id") Long id
        List<User> users = userRepository.findAllUserName();

        String login = request.getParameter("login");
        String password = request.getParameter("password");

        List<Long> idQuestion = questionService.findLatest2();
        model.addAttribute("idQuestion", idQuestion);

        List<String> nameQuestion = questionService.findNameQuestions();
        model.addAttribute("nameQuestion", nameQuestion);

        List<Question> questions = questionService.findAllQuestions();
        model.addAttribute("questions", questions);
        for (User loginUser: users) {
            if (login.equals(loginUser.getLogin())){
                request.setAttribute("userLogin", login);

                return "main";
            }
        }

        return "loginError";
    }

}
