package com.wu.vaccine.VaccinationMSystem.exception;

public class UserAlreadyVaccinatedException extends RuntimeException{
    public UserAlreadyVaccinatedException(String message){
        super(message);
    }
    public UserAlreadyVaccinatedException(Throwable cause){
        super(cause);
    }
    public UserAlreadyVaccinatedException(String message, Throwable cause){
        super(message,cause);
    }
    public UserAlreadyVaccinatedException(String message, Throwable cause, boolean enableSuppersion, boolean writableStackTrace){
        super(message,cause,enableSuppersion,writableStackTrace);
    }
}