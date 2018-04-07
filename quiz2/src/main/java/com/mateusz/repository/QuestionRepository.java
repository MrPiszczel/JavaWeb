package com.mateusz.repository;

import com.mateusz.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {


    @Query(value="select e from Question e")
    List<Question> findAllQuestions();
}
