package com.example.cinema.backend.application.entitiy;

import jakarta.persistence.*;

import java.sql.Time;
@Entity
@Table(name = "transactions")
public class Transactions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private User user;
    @ManyToOne
    private Movies movies;
    @ManyToOne
    private Theater theater;
    @ManyToOne
    @JoinColumn(name = "ticket_Type_Id")
    private Tickets tickets;
    @Column(name = "movie_start_time")
    private Time MovieStartTime;
    @Column(name = "movie_end_time")
    private Time MovieEndTime;
    @Column(name = "row_number_seat")
    private int RowNumberSeat;
    @Column(name = "column_number_seat")
    private int ColumnNumberSeat;
    @Column(name = "Ticket_Price")
    private Double TicketPrice;

    public Transactions() {

    }

    public Transactions(User user, Movies movies, Theater theater,
                        Tickets tickets, Time movieStartTime, Time movieEndTime,
                        int rowNumberSeat, int columnNumberSeat, Double ticketPrice) {
        this.user = user;
        this.movies = movies;
        this.theater = theater;
        this.tickets = tickets;
        MovieStartTime = movieStartTime;
        MovieEndTime = movieEndTime;
        RowNumberSeat = rowNumberSeat;
        ColumnNumberSeat = columnNumberSeat;
        TicketPrice = ticketPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Movies getMovies() {
        return movies;
    }

    public void setMovies(Movies movies) {
        this.movies = movies;
    }

    public Theater getTheater() {
        return theater;
    }

    public void setTheater(Theater theater) {
        this.theater = theater;
    }

    public Tickets getTickets() {
        return tickets;
    }

    public void setTickets(Tickets tickets) {
        this.tickets = tickets;
    }

    public Time getMovieStartTime() {
        return MovieStartTime;
    }

    public void setMovieStartTime(Time movieStartTime) {
        MovieStartTime = movieStartTime;
    }

    public Time getMovieEndTime() {
        return MovieEndTime;
    }

    public void setMovieEndTime(Time movieEndTime) {
        MovieEndTime = movieEndTime;
    }

    public int getRowNumberSeat() {
        return RowNumberSeat;
    }

    public void setRowNumberSeat(int rowNumberSeat) {
        RowNumberSeat = rowNumberSeat;
    }

    public int getColumnNumberSeat() {
        return ColumnNumberSeat;
    }

    public void setColumnNumberSeat(int columnNumberSeat) {
        ColumnNumberSeat = columnNumberSeat;
    }

    public Double getTicketPrice() {
        return TicketPrice;
    }

    public void setTicketPrice(Double ticketPrice) {
        TicketPrice = ticketPrice;
    }

    @Override
    public String toString() {
        return "Transactions{" +
                "id=" + id +
                ", user=" + user +
                ", movies=" + movies +
                ", theater=" + theater +
                ", tickets=" + tickets +
                ", MovieStartTime=" + MovieStartTime +
                ", MovieEndTime=" + MovieEndTime +
                ", RowNumberSeat=" + RowNumberSeat +
                ", ColumnNumberSeat=" + ColumnNumberSeat +
                ", TicketPrice=" + TicketPrice +
                '}';
    }
}
