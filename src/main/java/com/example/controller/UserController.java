package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.repository.UserRepository;
import com.example.entity.User;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:3000/")
public class UserController {
	
  @Autowired
  private UserRepository userRepository;

  @PostMapping(path="/adduser") 
  public @ResponseBody String addNewUser (@RequestParam String email
      , @RequestParam String password, @RequestParam String role) {

    User u = new User();
    u.setEmail(email);
    u.setPassword(password);
    u.setRole(role);
    userRepository.save(u);
    return "Saved";
  }

  @GetMapping("/users")
  public @ResponseBody Iterable<User> getAllUsers() {
    return userRepository.findAll();
  }
  
  @PostMapping("/userLogin")
  public ResponseEntity<String> login(@RequestParam String email, @RequestParam String password) {

      User user = userRepository.findByEmailAndPassword(email, password);

      if (user == null) {
          return new ResponseEntity<>("Invalid email or password", HttpStatus.BAD_REQUEST);
      }

      return new ResponseEntity<>(user.getRole(), HttpStatus.OK);
  }
}