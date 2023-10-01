package com.example.cinema.backend.application.service;

import com.example.cinema.backend.application.entitiy.Transactions;
import com.example.cinema.backend.application.entitiy.User;
import com.example.cinema.backend.application.error.MoiveStartException;
import com.example.cinema.backend.application.error.SeatNotAvailableException;
import com.example.cinema.backend.application.repository.BookingRepository;
import com.example.cinema.backend.application.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

@Service
public class BookingService {
    private  final BookingRepository bookingRepository;
    private final TransactionRepository transactionRepository;
    /*private int bookingCounter=0;*/
    @Autowired
    public BookingService(BookingRepository bookingRepository, TransactionRepository transactionRepository) {
     this.bookingRepository = bookingRepository;
        this.transactionRepository = transactionRepository;
    }
    public Transactions bookingSeats (Transactions booking){
        if (!isSeatAvailable(booking.getRowNumberSeat() , booking.getColumnNumberSeat())){
            throw new SeatNotAvailableException("The selected seat is not available");
      }
        /*if ( !isUserAuthorized(booking.getUser())) {
            throw new UnauthorizedBookingException("User is not authorized to make this booking.");
        }*/
      if (booking.getMovies()!=null){
            LocalTime currentTime= LocalTime.now();
            if (booking.getMovies().getShowTime().isBefore(currentTime)){
                throw new MoiveStartException("movie start !");
            }}




        return bookingRepository.save(booking);
    }
   /* public int checkAndIncrementCounter(int rowNumberSeat, int columnNumberSeat){
        Transactions existingBooking = transactionRepository.findBy();

    }*/


    private boolean isUserAuthorized(User user) {
       return true;
    }

    private Boolean isSeatAvailable(int RowNumberSeat , int ColumnNumberSeat ) {
       return true;
    }
}
