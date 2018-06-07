package com.example.webdevhw.repositories;

import com.example.webdevhw.models.Question;

import org.springframework.data.repository.CrudRepository;

public interface QuestionRepository
        extends CrudRepository<Question, Integer>{
}