package com.example.cinema.backend.application.entitiy;

import jakarta.persistence.*;


import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "movie")
public class Movies {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "price")
    private double price;
    @Column(name = "show_Time")
    private LocalTime showTime;

    @Column(name = "details")
    private String details;
    @Column(name = "movie_Name")
    private String movieName;

    /*@Column(name = "StartTime")
    private Date StartTime ;*/

    @OneToMany(mappedBy = "movies")
    private List<Transactions> transactions;

    public Movies() {

    }

    public Movies(double price, LocalTime showTime, String details,
                  String movieName
                  ,List<Transactions> transactions) {
        this.price = price;
        this.showTime = showTime;
        this.details = details;
        this.movieName = movieName;

        this.transactions = transactions;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalTime getShowTime() {
        return showTime;
    }

    public void setShowTime(LocalTime showTime) {
        this.showTime = showTime;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public List<Transactions> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transactions> transactions) {
        this.transactions = transactions;
    }

    @Override
    public String toString() {
        return "Movies{" +
                "id=" + id +
                ", price=" + price +
                ", showTime=" + showTime +
                ", details='" + details + '\'' +
                ", movieName='" + movieName + '\'' +
                ", transactions=" + transactions +
                '}';
    }
}
