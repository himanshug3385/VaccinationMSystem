package com.wu.vaccine.VaccinationMSystem.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class CitizenRestExceptionHandler {
    public ResponseEntity<CitizenErrorResponse> handleException(CitizenNotFoundException obj){
        CitizenErrorResponse myResponse = new CitizenErrorResponse(HttpStatus.NOT_FOUND.value(),obj.getMessage(), System.currentTimeMillis());
        return new ResponseEntity<>(myResponse,HttpStatus.NOT_FOUND);
    }
    public ResponseEntity<CitizenErrorResponse> handleException(Exception e){
        CitizenErrorResponse myResonse=new CitizenErrorResponse(HttpStatus.BAD_REQUEST.value(), e.getMessage(),System.currentTimeMillis());
        return  new ResponseEntity<>(myResonse,HttpStatus.NOT_FOUND);
    }
}
