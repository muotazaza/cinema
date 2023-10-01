package com.example.cinema.backend.application.error;

public class SeatNotAvailableException extends RuntimeException{
    public SeatNotAvailableException(String message) {
        super(message);
    }

    public SeatNotAvailableException(String message, Throwable cause) {
        super(message, cause);
    }

    public SeatNotAvailableException(Throwable cause) {
        super(cause);
    }
}
