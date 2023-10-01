package com.example.cinema.backend.application.repository;

import com.example.cinema.backend.application.entitiy.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Optional<Role>findByName(String name);
}
