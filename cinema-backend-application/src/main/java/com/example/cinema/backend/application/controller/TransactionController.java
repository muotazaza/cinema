package com.example.cinema.backend.application.controller;

import com.example.cinema.backend.application.entitiy.Transactions;
import com.example.cinema.backend.application.service.TransactionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Transactions")
public class TransactionController {
    private final TransactionsService transactionsService;
    @Autowired
    public TransactionController(TransactionsService transactionsService) {
        this.transactionsService = transactionsService;
    }

    @GetMapping("/Transactions")
    public List<Transactions> getAllTransaction(){
        return transactionsService.getAllTransactions();
    }

    @GetMapping("/Transactions/{id}")
    public Optional<Transactions> getTransactionsById(@PathVariable Long id){
        return transactionsService.getTheaterById(id);
    }

    @PostMapping("/Transactions")
    public Transactions createTransactions(@RequestBody Transactions transactions){
        return transactionsService.createTransactions(transactions);
    }

    @PutMapping("/Transactions")
    public Transactions updateTransactions(@PathVariable Long id,@RequestBody Transactions transactions){
        return transactionsService.update(id,transactions);
    }
    
    @DeleteMapping("/{id}")
    public void deleteTransactions(@PathVariable Long id){
        transactionsService.deleteTransactions(id);
    }
}
