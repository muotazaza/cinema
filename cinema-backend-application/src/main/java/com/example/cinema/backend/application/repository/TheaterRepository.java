package com.example.cinema.backend.application.repository;

import com.example.cinema.backend.application.entitiy.Theater;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheaterRepository extends JpaRepository<Theater,Long> {
}
