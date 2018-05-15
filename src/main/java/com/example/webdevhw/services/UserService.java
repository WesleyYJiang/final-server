package com.example.webdevhw.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.webdevhw.models.User;
import com.example.webdevhw.repositories.UserRepository;

@RestController
public class UserService {
  @Autowired
  UserRepository repository;

  @GetMapping("/api/user")
  public List<User> findAllUser() {
    return (List<User>) repository.findAll();
  }

  @PostMapping("/api/user")
  public User createUser(@RequestBody User user) {
    return repository.save(user);
  }

  @DeleteMapping("/api/user/{userId}")
  public void deleteUser(@PathVariable("userId") int id) {
    repository.deleteById(id);
  }

  @PutMapping("/api/user/{userId}")
  public User updateUser(@PathVariable("userId") int userId, @RequestBody User newUser) {
    Optional<User> data = repository.findById(userId);
    if (data.isPresent()) {
      User user = data.get();
      user.setFirstName(newUser.getFirstName());
      repository.save(user);
      return user;
    }
    return null;
  }

  @GetMapping("/api/user/{userId}")
  public User findUserById(@PathVariable("userId") int userId) {
    Optional<User> data = repository.findById(userId);
    if (data.isPresent()) {
      return data.get();
    }
    return null;
  }

  @GetMapping("/api/user/{username}")
  public User findUserByUsername(@PathVariable("username") String username) {
    Optional<User> data = repository.findUserByUsername(username);
    if (data.isPresent()) {
      return data.get();
    }
    return null;
  }

}
