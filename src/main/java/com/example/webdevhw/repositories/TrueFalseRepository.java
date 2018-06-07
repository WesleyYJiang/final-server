package com.example.webdevhw.repositories;

import com.example.webdevhw.models.TrueFalseQuestion;

import org.springframework.data.repository.CrudRepository;

public interface TrueFalseRepository
        extends CrudRepository<TrueFalseQuestion, Integer>{
}