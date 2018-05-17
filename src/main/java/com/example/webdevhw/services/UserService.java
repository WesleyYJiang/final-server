package com.example.webdevhw.services;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.webdevhw.models.User;
import com.example.webdevhw.repositories.UserRepository;

import javax.servlet.http.HttpSession;

@RestController
public class UserService {
  @Autowired
  UserRepository repository;

  @GetMapping("/api/user") // /api/user?username=alice
  public List<User> findAllUser(@RequestParam(value = "username", required = false) String username) {
    if(username == null) {
      return (List<User>) repository.findAll();
    } else {
      return Arrays.asList(findUserByUsername(username));
    }
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
  public User updateUser(@PathVariable("userId") int userId, @RequestBody User newUser)throws Exception  {
    Optional<User> data = repository.findById(userId);
    if (data.isPresent()) {
      User user = data.get();
      if (newUser.getEmail() != null){ user.setEmail(newUser.getEmail());}
      if (newUser.getDateOfBirth() != null){ user.setDateOfBirth(newUser.getDateOfBirth());}
      if (newUser.getPhone() != null){user.setPhone(newUser.getPhone());}

      if (newUser.getUsername() != null){user.setUsername(newUser.getUsername());}
      if (newUser.getFirstName() != null){user.setFirstName(newUser.getFirstName());}
      if (newUser.getLastName() != null){user.setLastName(newUser.getLastName());}
      if (newUser.getRole() != null){user.setRole(newUser.getRole());}
      repository.save(user);
      return user;
    }
    else{
      throw new Exception("bad");
    }
  }

  private User findUserByUsername(String username) {
    Optional<User> data = repository.findUserByUsername(username);
    if (data.isPresent()) {
      return data.get();
    }
    return null;
  }


  @PostMapping("/api/register")
  public User register(@RequestBody User user, HttpSession session) throws Exception {
    if(this.findUserByUsername(user.getUsername()) == null){
      session.setAttribute("currentUser", user);
      return repository.save(user);
    }
    else{
      throw new Exception("bad");
    }
  }

  @PostMapping("/api/login")
  public User login(@RequestBody User user, HttpSession session) throws Exception{
    Optional<User> data = repository.findUserByUsernameAndPassword(
            user.getUsername(), user.getPassword());
    if (data.isPresent()) {
      session.setAttribute("currentUser", user);
      return data.get();
    }
    else{
      throw new Exception("bad");
    }
  }

  @PostMapping("/api/logout")
  public void logout (HttpSession session) {
    session.invalidate();
  }

  @GetMapping("/api/profile")
  public User profile(HttpSession session) {
    User currentUser = (User)
            session.getAttribute("currentUser");
    return currentUser;
  }
}
