package com.mateusz.Controller;

import com.mateusz.model.Question;
import com.mateusz.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @RequestMapping("questions/view/{id}")
    public String view(@PathVariable("id") Long id, Model model) {
        Question question = questionService.findById(id); // to change
        model.addAttribute("question", question);

        return "questions/view";
    }
}
