package com.wu.vaccine.VaccinationMSystem.rest;


import com.wu.vaccine.VaccinationMSystem.DAO.CitizenDAO;

import com.wu.vaccine.VaccinationMSystem.DAO.DoseDAO;
import com.wu.vaccine.VaccinationMSystem.DAO.VaccineDAO;

import com.wu.vaccine.VaccinationMSystem.entity.Citizen;

import com.wu.vaccine.VaccinationMSystem.entity.Dose;

import com.wu.vaccine.VaccinationMSystem.entity.Vaccine;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController


public class VaccineController {

    private VaccineDAO vaccineDAO;
    private DoseDAO doseDAO;

    public VaccineController(VaccineDAO thevaccine, DoseDAO thedoseDAO) {

        this.vaccineDAO = thevaccine;
        this.doseDAO=thedoseDAO;

    }

    @GetMapping("/")

    public List<Vaccine> vaccineDetails() {

        List<Vaccine>res= vaccineDAO.getAllVaccineDetails();
       // model.addAttribute("vaccineData",res);
        return res;

    }

    @GetMapping("/api/vaccine/certificate/{citizenId}")

    public String certificateById(@PathVariable String citizenId) {
        String vacc = vaccineDAO.getCertificateIdById(citizenId);
        return vacc;

    }
    @PutMapping("/api/vaccine/{citizenId}")
    public void takeDose(@PathVariable String citizenId){
        vaccineDAO.updateVaccineDetails(citizenId);

    }
    @GetMapping("/api/vaccine/update/{citizenId}")
    public String funf(@PathVariable String citizenId){
//        Vaccine vaccine=vaccineDAO.getVaccineDetailsByID(citizenId);
//        List<Dose> doses= doseDAO.getDoseDetailsByCitizenId(citizenId);
//        System.out.println(doses);
        return "Details Updated";
    }
    @GetMapping("/api/vaccine/{citizenId}")
    public Vaccine vaccineDetailsById(@PathVariable String citizenId) {

        Vaccine vacc = vaccineDAO.getVaccineDetailsByID(citizenId);

        return  vacc;

    }

}
