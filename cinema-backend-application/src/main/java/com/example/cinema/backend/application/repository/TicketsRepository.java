package com.example.cinema.backend.application.repository;

import com.example.cinema.backend.application.entitiy.Tickets;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketsRepository extends JpaRepository<Tickets,Long> {
}
