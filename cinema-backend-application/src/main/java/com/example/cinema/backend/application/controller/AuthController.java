package com.example.cinema.backend.application.controller;

import com.example.cinema.backend.application.Dto.AuthResponseDTO;
import com.example.cinema.backend.application.entitiy.Role;
import com.example.cinema.backend.application.entitiy.User;
import com.example.cinema.backend.application.repository.RoleRepository;
import com.example.cinema.backend.application.repository.UserRepository;
import com.example.cinema.backend.application.Dto.LoginDto;
import com.example.cinema.backend.application.Dto.RegisterDTO;
import com.example.cinema.backend.application.security.JWTGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final JWTGenerator jwtGenerator;
    private  AuthenticationManager authenticationManager;
    private AuthenticationConfiguration authenticationConfiguration;
    private UserRepository userRepository;
    private RoleRepository roleRepository;

    private PasswordEncoder passwordEncoder;
    @Autowired
//    public AuthController(AuthenticationConfiguration authenticationConfiguration,
//                          UserRepository userRepository,
//
//                          RoleRepository roleRepository,PasswordEncoder passwordEncoder) {
//        this.authenticationConfiguration = authenticationConfiguration;
//        this.userRepository = userRepository;
//        this.roleRepository = roleRepository;
//        this.passwordEncoder = passwordEncoder;
//    }
    public AuthController(AuthenticationManager authenticationManager, UserRepository userRepository,
                          RoleRepository roleRepository, PasswordEncoder passwordEncoder, JWTGenerator jwtGenerator) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtGenerator = jwtGenerator;
    }


    @PostMapping("/login")
    public ResponseEntity<AuthResponseDTO> login(@RequestBody LoginDto loginDto){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDto.getUsername(),
                        loginDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtGenerator.generateToken(authentication);
        return new ResponseEntity<>(new AuthResponseDTO(token), HttpStatus.OK);
    }
    @PostMapping("/register")
    public ResponseEntity<String> register (@RequestBody RegisterDTO registerDTO){

        System.out.println(registerDTO);
        if (userRepository.existsByUserName(registerDTO.getUsername())){
            return new ResponseEntity<>("username is taken!", HttpStatus.BAD_REQUEST);
        }
        User user=new User();
        user.setUserName(registerDTO.getUsername());
        user.setPassword(passwordEncoder.encode(registerDTO.getPassword()));
        user.setEmail(registerDTO.getEmail());
        Role roles= roleRepository.findByName("USER").get();

        user.setRole("USER");

        Role role = roleRepository.findById(registerDTO.getRoleId()).get();
        user.getRoles().add(role);
        user.setRoles(Collections.singletonList(role));
        userRepository.save(user);

        return new ResponseEntity<>("user register success",HttpStatus.OK);
    }
}
