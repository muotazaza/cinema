
package com.example.cinema.backend.application.controller;


import com.example.cinema.backend.application.entitiy.MovieDailySalesReport;
import com.example.cinema.backend.application.service.DailyReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/dailyReport")
public class DailyReportController {



    private DailyReportService dailyReportService;
    @Autowired
    public DailyReportController(DailyReportService dailyReportService) {
        this.dailyReportService = dailyReportService;
    }

    @GetMapping
    public List<MovieDailySalesReport> getAllReport(){
        return dailyReportService.getAllReport();
    }


}
