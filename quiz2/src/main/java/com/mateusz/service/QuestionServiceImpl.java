package com.mateusz.service;

import com.mateusz.model.Question;
import com.mateusz.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService{

    @Autowired
    private QuestionRepository questionRepository;

   @Override
   public List<Long> findLatest2() {

       List<Long> question = questionRepository.findAllid();

       return question;
   }

   @Override
    public List<String> findNameQuestions() {

       List<String> questionName = questionRepository.findAllName();

       return questionName;
   }

   @Override
    public List<Question> findAllQuestions(){
       List<Question> questions = questionRepository.findAllQuestions();
       return questions;
   }

   @Override
    public Question findById(Long id){

       List<Question> question =questionRepository.findAllQuestions();
       Question idQuestion = new Question();

       for(Question q : question){
           if(id.equals(q.getId())){
               idQuestion.setQuestion(q.getQuestion());
               idQuestion.setId(q.getId());
               idQuestion.setAnswerOne(q.getAnswerOne());
               idQuestion.setAnswerTwo(q.getAnswerTwo());
               idQuestion.setAnswerThree(q.getAnswerThree());
               idQuestion.setAnswerFour(q.getAnswerFour());
               idQuestion.setTrueAnswer(q.getTrueAnswer());
               return idQuestion;
           }
       }
       return idQuestion;
   }

}
