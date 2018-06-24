package com.example.webdevhw.repositories;

import com.example.webdevhw.models.Campaign;

import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Campaign, Integer> {
}
