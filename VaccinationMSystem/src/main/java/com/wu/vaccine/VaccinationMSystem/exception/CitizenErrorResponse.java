package com.wu.vaccine.VaccinationMSystem.exception;

public class CitizenErrorResponse {
    private int status;
    private String message;
    private long timestamp;


    public CitizenErrorResponse(int status, String message, long timestamp) {
         super();
        this.status = status;
        this.message = message;
        this.timestamp = timestamp;
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

    public long getTimstamp() {
        return timestamp;
    }

    public void setTimstamp(long timstamp) {
        this.timestamp = timstamp;
    }
}
