package com.example.cinema.backend.application.error;

public class ErrorResponse {
    private int status;
    private String Message ;
    private Long TimeStamp;

    public ErrorResponse() {

    }

    public ErrorResponse(int status, String message, Long timeStamp) {
        this.status = status;
        Message = message;
        TimeStamp = timeStamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public Long getTimeStamp() {
        return TimeStamp;
    }

    public void setTimeStamp(Long timeStamp) {
        TimeStamp = timeStamp;
    }
}
