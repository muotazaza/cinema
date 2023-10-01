package com.example.cinema.backend.application.repository;

import com.example.cinema.backend.application.entitiy.Movies;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movies,Long> {
}
