package com.wu.vaccine.VaccinationMSystem.rest;


import com.wu.vaccine.VaccinationMSystem.DAO.DoseDAO;
import com.wu.vaccine.VaccinationMSystem.entity.Dose;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class DoseController {
    private DoseDAO doseDAO;
    public DoseController(DoseDAO thedosedao) {
        this.doseDAO=thedosedao;
    }

    @GetMapping("/dose/{citizenId}")
    public Dose DoseDetailsByCitizenId(@PathVariable String citizenId){
        return doseDAO.getDoseDetailsByCitizenId(citizenId);
    }

    @GetMapping("/dose/details/{doseId}")
    public Dose DoseDetailsByDoseId(@PathVariable String doseId){
        return doseDAO.getDoseDetailsByDoseId(doseId);
    }

    @DeleteMapping("/dose/{doseId}")
    public String deleteDose(@PathVariable String doseId){
        doseDAO.deleteDoseByDoseId(doseId);
        return "dose details are deleted";
    }
}