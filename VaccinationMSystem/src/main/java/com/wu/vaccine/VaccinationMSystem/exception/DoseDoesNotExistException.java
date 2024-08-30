package com.wu.vaccine.VaccinationMSystem.exception;

public class DoseDoesNotExistException extends RuntimeException{
    public DoseDoesNotExistException(String message){
        super(message);
    }
    public DoseDoesNotExistException(Throwable cause){
        super(cause);
    }
    public DoseDoesNotExistException(String message, Throwable cause){
        super(message,cause);
    }
    public DoseDoesNotExistException(String message, Throwable cause, boolean enableSuppersion, boolean writableStackTrace){
        super(message,cause,enableSuppersion,writableStackTrace);
    }

}
