package com.wu.vaccine.VaccinationMSystem.exception;

public class DeleteNotAllowedException extends RuntimeException{

    public  DeleteNotAllowedException(){

    }
    public DeleteNotAllowedException(String message){
        super(message);
    }
    public DeleteNotAllowedException(Throwable cause){
        super(cause);
    }
    public DeleteNotAllowedException(String message, Throwable cause){
        super(message,cause);
    }
    public DeleteNotAllowedException(String message, Throwable cause, boolean enableSuppersion, boolean writableStackTrace){
        super(message,cause,enableSuppersion,writableStackTrace);
    }
}
