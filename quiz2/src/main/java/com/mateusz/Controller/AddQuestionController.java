package com.mateusz.Controller;


import com.mateusz.model.Question;
import com.mateusz.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AddQuestionController {

    @Autowired
    private QuestionRepository questionRepository;

    @RequestMapping("/addQuestion")
    public String addQuestion(){
       return "addQuestion";
    }

    @RequestMapping("/saveQuestion")
    public String saveQuestion(HttpServletRequest request) {

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

        return "main";
    }

}