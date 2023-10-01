package com.example.cinema.backend.application.service;

import com.example.cinema.backend.application.entitiy.Tickets;
import com.example.cinema.backend.application.repository.TicketsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketsService {
    private final TicketsRepository ticketsRepository;

    @Autowired
    public TicketsService(TicketsRepository ticketsRepository) {
        this.ticketsRepository = ticketsRepository;
    }

    public List<Tickets> getAllTickets() {
        return ticketsRepository.findAll();
    }

    public Optional<Tickets> getTicketsById(Long id) {
        return ticketsRepository.findById(id);
    }

    public Tickets createTickets(Tickets tickets) {
        return ticketsRepository.save(tickets);
    }

    public Tickets updateTickets(Long id, Tickets tickets) {
        if (ticketsRepository.existsById(id)) {
            tickets.setTicketTypeId(id);

            return ticketsRepository.save(tickets);
        }
        return null;
    }

    public void deleteTickets(Long id) {
        ticketsRepository.deleteById(id);
    }

}
