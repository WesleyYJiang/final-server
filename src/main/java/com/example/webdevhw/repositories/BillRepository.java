package com.example.webdevhw.repositories;

import com.example.webdevhw.models.Lesson;

import org.springframework.data.repository.CrudRepository;

public interface LessonRepository extends CrudRepository<Lesson, Integer> {
}
