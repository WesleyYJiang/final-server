package com.example.webdevhw.repositories;

import com.example.webdevhw.models.FillInTheBlankQuestion;

import org.springframework.data.repository.CrudRepository;

public interface FillInTheBlankQuestionRepository
        extends CrudRepository<FillInTheBlankQuestion, Integer> {
}
