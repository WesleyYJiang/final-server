package com.example.webdevhw.repositories;


import com.example.webdevhw.models.EssayQuestion;

import org.springframework.data.repository.CrudRepository;

public interface EssayQuestionRepository
        extends CrudRepository<EssayQuestion, Integer> {
}
