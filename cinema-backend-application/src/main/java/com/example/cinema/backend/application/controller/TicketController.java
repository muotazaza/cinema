package com.example.cinema.backend.application.controller;

import com.example.cinema.backend.application.entitiy.Tickets;
import com.example.cinema.backend.application.service.TicketsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Tickets")
public class TicketController {

    private final TicketsService ticketsService;

    @Autowired
    public TicketController(TicketsService ticketsService) {
        this.ticketsService = ticketsService;
    }


    @GetMapping("/Tickets")
    public List<Tickets> getAllTickets(){
        return ticketsService.getAllTickets();

    }

    @GetMapping("/Tickets/{id}")
    Optional<Tickets> getTicketsById(@PathVariable Long id){

        return ticketsService.getTicketsById(id);
    }

    @PostMapping("/Tickets")
    public Tickets createTickets(@RequestBody Tickets tickets) {

        return ticketsService.createTickets(tickets);
    }

    @PutMapping("/{id}")
    public Tickets updateTickets(@PathVariable Long id, @RequestBody Tickets tickets) {
        return ticketsService.updateTickets(id, tickets);
    }

    @DeleteMapping("/{id}")
    public void deleteTickets(@PathVariable Long id){
    ticketsService.deleteTickets(id);
    }
}
