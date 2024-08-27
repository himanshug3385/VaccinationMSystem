package com.wu.vaccine.VaccinationMSystem.rest;


import com.wu.vaccine.VaccinationMSystem.entity.Citizen;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;

import com.wu.vaccine.VaccinationMSystem.DAO.CitizenDAO;
import com.wu.vaccine.VaccinationMSystem.entity.Citizen;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CitizenController {
    private CitizenDAO cDao;
    public CitizenController(CitizenDAO thecitizedao) {
        this.cDao=thecitizedao;
    }


    @GetMapping("/citizen")
    public List<Citizen> getCitizens(){
        return cDao.getAllCitizenDetails();
    }

    @GetMapping("/citizen/{citizenId}")
    public Citizen fun2(@PathVariable String citizenId) {
       return cDao.getCitizenDetailsById(citizenId);
    }

    @PostMapping("/registercitizen")
    public Citizen addcitizen(@RequestBody Citizen thecitizen) {
       // Date d=
        thecitizen.setCitizenId("0");
        cDao.registerCitizen(thecitizen);
        return thecitizen;
    }

    @PutMapping("/citizen")
    public Citizen updateCustomer(@RequestBody Citizen theciti) {
        return cDao.upDateCitizenDetails(theciti);

    }

    @DeleteMapping("/citizen/{citizenId}")
    public String deleterCustomer(@PathVariable String citizenId) {
        Citizen citi=cDao.getCitizenDetailsById(citizenId);
        cDao.deleteCitizenDetails(citi);
        return "citizen details deleted";
    }

    @GetMapping("/citizen/status/{citizenId}")
    public String getStatusbyId(@PathVariable String citizenId){
        return  cDao.getCitizenDetailsByStatus(citizenId);
    }

    @GetMapping("/citizens/status/{status}")
    public List<Citizen> fun4(@PathVariable String status){
        List<Citizen> citi=cDao.getAllCitizenDetailsByStatus(status);
        return citi;
    }



}

