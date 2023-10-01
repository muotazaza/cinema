package com.example.cinema.backend.application.repository;

import com.example.cinema.backend.application.entitiy.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transactions,Long> {
}
