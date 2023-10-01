package com.example.cinema.backend.application.service;

import com.example.cinema.backend.application.entitiy.Transactions;
import com.example.cinema.backend.application.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionsService {
    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionsService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public List<Transactions> getAllTransactions(){
        return transactionRepository.findAll();
    }
    public Optional<Transactions> getTheaterById(Long id){
        return transactionRepository.findById(id);
    }
    public Transactions createTransactions(Transactions transactions){
        return transactionRepository.save(transactions);

    }
    public Transactions update(Long id , Transactions transactions){
        if (transactionRepository.existsById(id)){
            transactions.setId(id);
            return transactionRepository.save(transactions);
        }
        return null;
    }
    public void deleteTransactions(Long id){
        transactionRepository.deleteById(id);
    }

}
