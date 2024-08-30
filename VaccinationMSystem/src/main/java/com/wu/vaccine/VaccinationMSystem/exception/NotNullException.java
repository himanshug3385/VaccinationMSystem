package com.wu.vaccine.VaccinationMSystem.exception;

    public class NotNullException extends RuntimeException{
        public NotNullException(String message){
            super(message);
        }
        public NotNullException(Throwable cause){
            super(cause);
        }
        public NotNullException(String message, Throwable cause){
            super(message,cause);
        }
        public NotNullException(String message, Throwable cause, boolean enableSuppersion, boolean writableStackTrace){
            super(message,cause,enableSuppersion,writableStackTrace);
        }
    }

