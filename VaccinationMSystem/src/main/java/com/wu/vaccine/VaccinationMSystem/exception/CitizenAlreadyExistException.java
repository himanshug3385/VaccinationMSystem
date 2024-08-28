package com.wu.vaccine.VaccinationMSystem.exception;


public class CitizenAlreadyExistException extends RuntimeException {
    public  CitizenAlreadyExistException(){

    }
    public CitizenAlreadyExistException(String message){
        super(message);
    }
    public CitizenAlreadyExistException(Throwable cause){
        super(cause);
    }
    public CitizenAlreadyExistException(String message, Throwable cause){
        super(message,cause);
    }
    public CitizenAlreadyExistException(String message, Throwable cause, boolean enableSuppersion, boolean writableStackTrace){
        super(message,cause,enableSuppersion,writableStackTrace);
    }
}


