package com.example.cinema.backend.application.controller;

import com.example.cinema.backend.application.entitiy.MovieDailySalesReport;
import com.example.cinema.backend.application.entitiy.Transactions;
import com.example.cinema.backend.application.repository.MovieDailySalesReportRepository;
import com.example.cinema.backend.application.service.BookingService;
import com.example.cinema.backend.application.service.DailyReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/v1")
public class BookingController {
    private BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }


    @PostMapping("/booking")
    public Transactions bookingSeats(@RequestBody Transactions transactions){
        MovieDailySalesReport report = new MovieDailySalesReport();
        report.setMovieName("ok");
        report.setDate(LocalDate.now());
        report.setTotalSales
                (report.getTotalSales() * (transactions.getTicketPrice() * (transactions.getRowNumberSeat() + transactions.getColumnNumberSeat()) / 2));

        return bookingService.bookingSeats(transactions);

    }

}
