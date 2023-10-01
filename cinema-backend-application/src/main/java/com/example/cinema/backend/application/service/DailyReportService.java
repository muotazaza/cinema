
package com.example.cinema.backend.application.service;


import com.example.cinema.backend.application.entitiy.MovieDailySalesReport;
import com.example.cinema.backend.application.repository.MovieDailySalesReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class DailyReportService {

    @Autowired
    private MovieDailySalesReportRepository movieDailySalesReportRepository;

    public MovieDailySalesReport createAndSaveReport(MovieDailySalesReport
                                                             movieDailySalesReport){
        return movieDailySalesReportRepository.save(movieDailySalesReport);
    }
    public List<MovieDailySalesReport>getAllReport(){
        return movieDailySalesReportRepository.findAll();
    }









    /*  List<MovieDailySalesReport> generateDailySalesReport(LocalDate date);

    private BookingRepository bookingRepository;
    @Autowired
    public DailyReportService(DailySalesReportRepository dailySalesReportRepository) {

        this.dailySalesReportRepository = dailySalesReportRepository;
    }

    public List<MovieDailySalesReport> generateDailySalesReport(LocalDate date) {
        return dailySalesReportRepository.generateDailySalesReport(date);
    }*/
}
