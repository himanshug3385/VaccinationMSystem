package com.wu.vaccine.VaccinationMSystem.exception;

public class InformationUpdateNotAllowedException extends RuntimeException{
    public  InformationUpdateNotAllowedException(){

    }
    public InformationUpdateNotAllowedException(String message){
        super(message);
    }
    public InformationUpdateNotAllowedException(Throwable cause){
        super(cause);
    }
    public InformationUpdateNotAllowedException(String message, Throwable cause){
        super(message,cause);
    }
    public InformationUpdateNotAllowedException(String message, Throwable cause, boolean enableSuppersion, boolean writableStackTrace){
        super(message,cause,enableSuppersion,writableStackTrace);
    }
}
