package com.example.cinema.backend.application.entitiy;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;
@Data
@Entity
public class MovieDailySalesReport {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String movieName;
    private LocalDate date;
    private double totalSales;
    private int numberOfTickets;

    public MovieDailySalesReport(String movieName, LocalDate date,
                                 double totalSales, int numberOfTickets) {
        this.movieName = movieName;
        this.date = date;
        this.totalSales = totalSales;
        this.numberOfTickets = numberOfTickets;
    }

    public MovieDailySalesReport() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(double totalSales) {
        this.totalSales = totalSales;
    }




}
