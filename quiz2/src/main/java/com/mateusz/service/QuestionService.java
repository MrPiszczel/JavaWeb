package com.mateusz.service;

import com.mateusz.model.Question;

import java.util.List;

public interface QuestionService {
    List<Long> findLatest2();
    List<String> findNameQuestions();
    List<Question> findAllQuestions();
    Question findById(Long id);
}
