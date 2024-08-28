package com.wu.vaccine.VaccinationMSystem.rest;


import com.wu.vaccine.VaccinationMSystem.DAO.CitizenDAO;

import com.wu.vaccine.VaccinationMSystem.DAO.VaccineDAO;

import com.wu.vaccine.VaccinationMSystem.entity.Citizen;

import com.wu.vaccine.VaccinationMSystem.entity.Dose;

import com.wu.vaccine.VaccinationMSystem.entity.Vaccine;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")

public class VaccineController {

    private VaccineDAO vaccineDAO;

    public VaccineController(VaccineDAO thevaccine) {

        this.vaccineDAO = thevaccine;

    }

    @GetMapping("/vaccine")

    public List<Vaccine> vaccineDetails() {

        return vaccineDAO.getAllVaccineDetails();

    }

    @GetMapping("/vaccine/certificate/{citizenId}")

    public String certificateById(@PathVariable String citizenId) {
        String vacc = vaccineDAO.getCertificateIdById(citizenId);
        return vacc;

    }
    @PutMapping("/vaccine/{citizenId}")
    public void takeDose(@PathVariable String citizenId){
        vaccineDAO.updateVaccineDetails(citizenId);
    }
    @GetMapping("/vaccine/{citizenId}")

    public Vaccine vaccineDetailsById(@PathVariable String citizenId) {

        Vaccine vacc = vaccineDAO.getVaccineDetailsByID(citizenId);

        return  vacc;

    }

}

