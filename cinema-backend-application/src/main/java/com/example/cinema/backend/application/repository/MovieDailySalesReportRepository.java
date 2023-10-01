package com.example.cinema.backend.application.repository;

import com.example.cinema.backend.application.entitiy.MovieDailySalesReport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieDailySalesReportRepository extends JpaRepository<MovieDailySalesReport,Long> {
}
