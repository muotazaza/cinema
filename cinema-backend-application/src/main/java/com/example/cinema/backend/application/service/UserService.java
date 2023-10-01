package com.example.cinema.backend.application.service;

import com.example.cinema.backend.application.entitiy.User;
import com.example.cinema.backend.application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class
UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUser(){
        return userRepository.findAll();
    }
    public Optional<User> getUserById(Long id){
        return userRepository.findById(id);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }
    public User updateUser(Long id, User user){
        if (userRepository.existsById(id)){
            user.setId(id);
                return userRepository.save(user);
        }
        return null;
    }
    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }

}
