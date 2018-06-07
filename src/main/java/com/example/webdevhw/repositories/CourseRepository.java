package com.example.webdevhw.repositories;

import com.example.webdevhw.models.Course;

import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, Integer> {
}
