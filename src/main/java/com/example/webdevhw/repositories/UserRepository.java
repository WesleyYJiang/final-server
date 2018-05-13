package com.example.webdevhw.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.webdevhw.models.User;

public interface UserRepository extends CrudRepository<User, Integer>{

}
