package com.mateusz.Controller;


import com.mateusz.model.Question;
import com.mateusz.repository.QuestionRepository;
import com.mateusz.service.QuestionService;
import com.mateusz.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class AddQuestionController {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private QuestionService questionService;

    @Autowired
    private RegistrationService registrationService;

    @RequestMapping("/addQuestion")
    public String addQuestion(){
       return "addQuestion";
    }


    @RequestMapping("/saveQuestion")
    public String saveQuestion(HttpServletRequest request, Model model) {

        Question questions = new Question();

        String question = request.getParameter("question");
        String answerA = request.getParameter("answerA");
        String answerB = request.getParameter("answerB");
        String answerC = request.getParameter("answerC");
        String answerD = request.getParameter("answerD");
        String trueAnswer = request.getParameter("trueAnswer");

        questions.setQuestion(question);
        questions.setAnswerOne(answerA);
        questions.setAnswerTwo(answerB);
        questions.setAnswerThree(answerC);
        questions.setAnswerFour(answerD);
        questions.setTrueAnswer(trueAnswer);

        questionRepository.save(questions);

        List<Question> writeQuestions = questionService.findAllQuestions();
        model.addAttribute("questions", writeQuestions);

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        int point = registrationService.findUserPoints(name);
        model.addAttribute("points", point);

        return "main";
    }

}