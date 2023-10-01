package com.example.cinema.backend.application.entitiy;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "theater")
public class Theater {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "capacity")
    private int capacity;

    @OneToMany(mappedBy = "theater")
    private List<Transactions> transactions;

    public Theater() {

    }

    public Theater(int capacity, List<Transactions> transactions) {
        this.capacity = 64;
        this.transactions = transactions;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Transactions> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transactions> transactions) {
        this.transactions = transactions;
    }

    @Override
    public String toString() {
        return "Theater{" +
                "id=" + id +
                ", capacity=" + capacity +
                ", transactions=" + transactions +
                '}';
    }
}
