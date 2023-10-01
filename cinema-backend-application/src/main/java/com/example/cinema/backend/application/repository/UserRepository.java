package com.example.cinema.backend.application.repository;
import com.example.cinema.backend.application.entitiy.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByUserName (String ok);
   Boolean existsByUserName(String userName);
}
