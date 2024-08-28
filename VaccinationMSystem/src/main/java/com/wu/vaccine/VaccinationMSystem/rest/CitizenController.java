package com.wu.vaccine.VaccinationMSystem.rest;


import com.wu.vaccine.VaccinationMSystem.entity.Citizen;
import com.wu.vaccine.VaccinationMSystem.exception.CitizenNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import com.wu.vaccine.VaccinationMSystem.DAO.CitizenDAO;
import com.wu.vaccine.VaccinationMSystem.entity.Citizen;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static com.wu.vaccine.VaccinationMSystem.DAO.CitizenDAOImpl.is120DaysDifference;

@RestController
@RequestMapping("/api")
public class CitizenController {
    private CitizenDAO citizenDAO;
    public CitizenController(CitizenDAO thecitizedao) {
        this.citizenDAO=thecitizedao;
    }


    @GetMapping("/citizen")
    public List<Citizen> getCitizens(){
        return citizenDAO.getAllCitizenDetails();
    }

    @GetMapping("/citizen/{citizenId}")
    public Citizen fun2(@PathVariable String citizenId) {
       Citizen citizen= citizenDAO.getCitizenDetailsById(citizenId);
       if(citizen==null)
           throw new CitizenNotFoundException("Citizen Does Not Exist !!!");
       return citizen;
    }

    @PostMapping("/registercitizen")
    public Citizen addcitizen(@RequestBody Citizen thecitizen) {
        if(citizenDAO.checkIfCitizenExist(thecitizen.getAddhar_no())){
            //throw an exception citizen already exist.
            
        }
        LocalDate currentDate = LocalDate.now();
        thecitizen.setLast_vaccinated(currentDate.toString());
        thecitizen.setCitizenId(thecitizen.getAddhar_no());
        citizenDAO.registerCitizen(thecitizen);
        return thecitizen;
    }



    @DeleteMapping("/citizen/{citizenId}")
    public String deleterCustomer(@PathVariable String citizenId) {
        Citizen citi=citizenDAO.getCitizenDetailsById(citizenId);
        LocalDate current= LocalDate.now();
        if(is120DaysDifference(current,LocalDate.parse(citi.getLast_vaccinated())))
            //  throw exception

        citizenDAO.deleteCitizenDetails(citi);
        return "citizen details deleted";
    }

    @GetMapping("/citizen/status/{citizenId}")
    public String getStatusbyId(@PathVariable String citizenId){
        return  citizenDAO.getCitizenDetailsByStatus(citizenId);
    }

    @GetMapping("/citizens/status/{status}")
    public List<Citizen> fun4(@PathVariable String status){
        List<Citizen> citi=citizenDAO.getAllCitizenDetailsByStatus(status);
        return citi;
    }



}

