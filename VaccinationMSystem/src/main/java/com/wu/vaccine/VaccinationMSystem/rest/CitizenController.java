package com.wu.vaccine.VaccinationMSystem.rest;


import com.wu.vaccine.VaccinationMSystem.entity.Citizen;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import com.wu.vaccine.VaccinationMSystem.DAO.CitizenDAO;
import com.wu.vaccine.VaccinationMSystem.entity.Citizen;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/api")
public class CitizenController {
    private CitizenDAO cDao;
    public CitizenController(CitizenDAO thecitizedao) {
        this.cDao=thecitizedao;
    }


    @GetMapping("citizen")
    public List<Citizen> getCitizens(){
        return cDao.getAllCitizenDetails();
    }

    @GetMapping("citizen/{citizenId}")
    public Citizen getCitizenDetailsById(@PathVariable String citizenId) {
        Citizen citi = cDao.getCitizenDetailsById(citizenId);
        return citi;
    }

    @PostMapping("/addcitizen")
    public Citizen addcitizen(@RequestBody Citizen thecitizen) {
        thecitizen.setCitizenId("0");
        cDao.registerCitizen(thecitizen);
        return thecitizen;
    }

    @PutMapping("/citizen")
    public Citizen updateCustomer(@RequestBody Citizen theciti) {

        cDao.registerCitizen(theciti);
        return theciti;
    }

    @DeleteMapping("/citizen/{citizenId}")
    public String deleterCustomer(@PathVariable String citizenId) {
        Citizen citi=cDao.getCitizenDetailsById(citizenId);
        cDao.deleteCitizenDetails(citi);
        return "citizen details deleted";
    }

    @GetMapping("/citizen/{citizenId}")
    public String getStatusbyId(@PathVariable String citizenId){
        return  cDao.getCitizenDetailsByStatus(citizenId);
    }

    @GetMapping("/citizen/{status}")
    public List<Citizen> getCitizenbyStatus(@PathVariable String status){
        List<Citizen> citi=cDao.getAllCitizenDetailsByStatus(status);
        return citi;
    }



}

