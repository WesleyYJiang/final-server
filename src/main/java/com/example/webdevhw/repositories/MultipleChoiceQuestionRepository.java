package com.example.webdevhw.repositories;


import com.example.webdevhw.models.MultipleChoiceQuestion;

import org.springframework.data.repository.CrudRepository;

public interface MultipleChoiceQuestionRepository
        extends CrudRepository<MultipleChoiceQuestion, Integer> {
}