package com.example.webdevhw.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.webdevhw.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer>{
  @Query("select u from User u where u.username = :username")
  Optional<User> findUserByUsername(@Param("username") String username);

  @Query("select u from User u where u.username = :username and u.password = :password")
  Optional<User> findUserByUsernameAndPassword(@Param("username") String username,
                                               @Param("password") String password);
}
