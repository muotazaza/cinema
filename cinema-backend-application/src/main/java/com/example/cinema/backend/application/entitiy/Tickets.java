package com.example.cinema.backend.application.entitiy;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tickets")
public class Tickets {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "ticket_Type_Id")
    private Long TicketTypeId;
 @Column(name = "Ticket_Type_Descriptions")
    private String TicketTypeDescriptions ;

 @OneToMany
 private List<Transactions> transactions;
    public Tickets() {
    }

    public Tickets(String ticketTypeDescriptions) {
        TicketTypeDescriptions = ticketTypeDescriptions;
    }

    public Long getTicketTypeId() {
        return TicketTypeId;
    }

    public void setTicketTypeId(Long ticketTypeId) {
        TicketTypeId = ticketTypeId;
    }

    public String getTicketTypeDescriptions() {
        return TicketTypeDescriptions;
    }

    public void setTicketTypeDescriptions(String ticketTypeDescriptions) {
        TicketTypeDescriptions = ticketTypeDescriptions;
    }

    @Override
    public String toString() {
        return "Tickets{" +
                "TicketTypeId=" + TicketTypeId +
                ", TicketTypeDescriptions='" + TicketTypeDescriptions + '\'' +
                '}';
    }
}
