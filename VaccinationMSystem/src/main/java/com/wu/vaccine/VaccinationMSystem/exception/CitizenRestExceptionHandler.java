package com.wu.vaccine.VaccinationMSystem.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CitizenRestExceptionHandler  {

    @ExceptionHandler
    public ResponseEntity<CitizenErrorResponse> handleException(CitizenNotFoundException obj){
        //fun2
        CitizenErrorResponse myResponse = new CitizenErrorResponse(HttpStatus.NOT_FOUND.value(),obj.getMessage(), System.currentTimeMillis());
        return new ResponseEntity(myResponse,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler
    public ResponseEntity<CitizenErrorResponse>handleException(Exception e){
        CitizenErrorResponse myResponse = new CitizenErrorResponse(HttpStatus.NOT_FOUND.value(),e.getMessage(), System.currentTimeMillis());
        return new ResponseEntity(myResponse,HttpStatus.BAD_REQUEST);
    }
//
    public ResponseEntity<CitizenErrorResponse> alreadyVaccinated(UserAlreadyVaccinatedException vaccine){
        //fun2
        CitizenErrorResponse myResponse = new CitizenErrorResponse(HttpStatus.NOT_FOUND.value(),vaccine.getMessage(), System.currentTimeMillis());
        return new ResponseEntity(myResponse,HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<CitizenErrorResponse> citizenAlreadyExists(CitizenAlreadyExistException citizenExist)
    {
        // already exists
        CitizenErrorResponse myResponse = new CitizenErrorResponse(HttpStatus.CONFLICT.value(),citizenExist.getMessage(), System.currentTimeMillis());
        return new ResponseEntity<CitizenErrorResponse>(myResponse,HttpStatus.CONFLICT);
    }

    public ResponseEntity<CitizenErrorResponse> doseNotAvailable(DoseDoesNotExistException doseNotAvailable)
    {
        CitizenErrorResponse myResponse = new CitizenErrorResponse(HttpStatus.BAD_GATEWAY.value(),doseNotAvailable.getMessage(), System.currentTimeMillis());
        return new ResponseEntity<CitizenErrorResponse>(myResponse,HttpStatus.BAD_GATEWAY);
    }

    public ResponseEntity<CitizenErrorResponse> NotNullException(NotNullException notNull)
    {
        CitizenErrorResponse myResponse = new CitizenErrorResponse(HttpStatus.NOT_ACCEPTABLE.value(),notNull.getMessage(), System.currentTimeMillis());
        return new ResponseEntity<CitizenErrorResponse>(myResponse,HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<CitizenErrorResponse> informationUpdateNotAllowed(InformationUpdateNotAllowedException notAllowed)
    {
        CitizenErrorResponse myResponse = new CitizenErrorResponse(HttpStatus.BAD_REQUEST.value(),notAllowed.getMessage(), System.currentTimeMillis());
        return new ResponseEntity<CitizenErrorResponse>(myResponse,HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<CitizenErrorResponse> deleteNotAllowed(DeleteNotAllowedException deleteNotAllowed)
    {
        CitizenErrorResponse myResponse = new CitizenErrorResponse(HttpStatus.BAD_REQUEST.value(),deleteNotAllowed.getMessage(), System.currentTimeMillis());
        return new ResponseEntity<CitizenErrorResponse>(myResponse,HttpStatus.BAD_REQUEST);
    }





}
