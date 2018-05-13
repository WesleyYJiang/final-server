package com.example.webdevhw.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.webdevhw.models.Hello;

public interface HelloRepository extends CrudRepository<Hello, Integer> {

}
