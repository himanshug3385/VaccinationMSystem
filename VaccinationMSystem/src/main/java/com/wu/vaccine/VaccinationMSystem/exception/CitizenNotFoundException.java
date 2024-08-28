package com.wu.vaccine.VaccinationMSystem.exception;

public class CitizenNotFoundException extends RuntimeException{
    public  CitizenNotFoundException(){

    }
    public CitizenNotFoundException(String message){
        super(message);
    }
    public CitizenNotFoundException(Throwable cause){
        super(cause);
    }
    public CitizenNotFoundException(String message, Throwable cause){
        super(message,cause);
    }
    public CitizenNotFoundException(String message, Throwable cause, boolean enableSuppersion, boolean writableStackTrace){
        super(message,cause,enableSuppersion,writableStackTrace);
    }
}
