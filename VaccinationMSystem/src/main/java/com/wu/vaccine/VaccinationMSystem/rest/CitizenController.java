package com.wu.vaccine.VaccinationMSystem.rest;


import com.wu.vaccine.VaccinationMSystem.entity.Citizen;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
        this.citizenDAO = thecitizedao;
    }
    //
    @GetMapping("/citizen")
    public List<Citizen> getCitizens() {
        List<Citizen> res = citizenDAO.getAllCitizenDetails();
        return res;
    }

    @GetMapping("/citizen/{citizenId}")
    public Citizen fun2(@PathVariable String citizenId) {
        Citizen citizen = citizenDAO.getCitizenDetailsById(citizenId);
        return citizen;
    }



    //api/citizen/register
    @PostMapping("/citizen/register")
    public Citizen addcitizen(@ModelAttribute("citizen") Citizen thecitizen) {
        citizenDAO.registerCitizen(thecitizen);
        return thecitizen;
//        return "redirect:dashboard";
    }


    @DeleteMapping("/citizen/{citizenId}")
    public Citizen deleterCustomer(@PathVariable String citizenId) {
        Citizen citi = citizenDAO.getCitizenDetailsById(citizenId);
        LocalDate current = LocalDate.now();
//        if(is120DaysDifference(current,LocalDate.parse(citi.getLast_vaccinated()))){
//            throw new DeleteNotAllowedException("Delete Not Allowed Due to Date Difference error");
//        }
        //  throw exception


        citizenDAO.deleteCitizenDetails(citi);
       return citi;
    }

    @GetMapping("/citizen/status/{citizenId}")
    public String getStatusbyId(@PathVariable String citizenId) {
        return citizenDAO.getCitizenDetailsByStatus(citizenId);
    }

    @GetMapping("/citizens/status/{status}")
    public List<Citizen> fun4(@PathVariable String status) {
        List<Citizen> citi = citizenDAO.getAllCitizenDetailsByStatus(status);
        return citi;
    }


}

