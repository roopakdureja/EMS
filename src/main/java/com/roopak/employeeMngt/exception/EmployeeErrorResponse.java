package com.roopak.employeeMngt.exception;

import java.time.LocalDateTime;

public class EmployeeErrorResponse {

    private int status;
    private String message;
    private LocalDateTime timeStamp;

    public EmployeeErrorResponse() {
    }

    public EmployeeErrorResponse(int status, String message, LocalDateTime timeStamp) {
        this.status = status;
        this.message = message;
        this.timeStamp = timeStamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }
}
