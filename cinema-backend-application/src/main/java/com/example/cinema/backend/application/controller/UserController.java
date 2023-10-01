package com.example.cinema.backend.application.controller;

import com.example.cinema.backend.application.entitiy.User;
import com.example.cinema.backend.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/user")
    public List<User> getAllUser(){
        return userService.getAllUser();
    }



    @GetMapping("/user/{id}")
    public Optional<User> getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @PostMapping("/user")
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }
    @PutMapping("/User")
    public User updateUser(@PathVariable Long id, @RequestBody User user ){
        return userService.updateUser(id,user);
    }
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }


}
