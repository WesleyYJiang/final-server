package com.example.webdevhw.repositories;

import com.example.webdevhw.models.Course;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by wesleyjiang on 5/20/18.
 */
public interface CourseRepository extends CrudRepository<Course, Integer> {
}
