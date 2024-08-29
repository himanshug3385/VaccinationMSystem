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


@Controller
@RequestMapping("/api")
public class CitizenController {
    private CitizenDAO citizenDAO;
    public CitizenController(CitizenDAO thecitizedao) {
        this.citizenDAO = thecitizedao;
    }
    //
    @GetMapping("/citizen")
    public String getCitizens(Model theModel) {
        List<Citizen> res = citizenDAO.getAllCitizenDetails();
        theModel.addAttribute("citizens",res);
        return "citizen";
    }

    @GetMapping("/citizen/{citizenId}")
    public String fun2(@PathVariable String citizenId) {
        Citizen citizen = citizenDAO.getCitizenDetailsById(citizenId);
        return "redirect:/";
    }

    @GetMapping("/citizen/registeration")
    public String showRegistrationForm(Model model) {
        model.addAttribute("citizen",new Citizen());
        return "register";
    }


    //api/citizen/register
    @PostMapping("/citizen/register")
    public String addcitizen(@ModelAttribute("citizen") Citizen thecitizen) {
        LocalDate currentDate = LocalDate.now();
        thecitizen.setLast_vaccinated(currentDate.toString());
        thecitizen.setCitizenId(thecitizen.getAddhar_no());
        System.out.println("Hlllo world");
        citizenDAO.registerCitizen(thecitizen);
        return "redirect:/";
//        return "redirect:dashboard";
    }


    @DeleteMapping("/citizen/{citizenId}")
    public String deleterCustomer(@PathVariable String citizenId) {
        Citizen citi = citizenDAO.getCitizenDetailsById(citizenId);
        LocalDate current = LocalDate.now();
//        if(is120DaysDifference(current,LocalDate.parse(citi.getLast_vaccinated()))){
//            throw new DeleteNotAllowedException("Delete Not Allowed Due to Date Difference error");
//        }
        //  throw exception


        citizenDAO.deleteCitizenDetails(citi);
        return "citizen details deleted";
    }

    @GetMapping("/citizen/status/{citizenId}")
    public String getStatusbyId(@PathVariable String citizenId) {
        return citizenDAO.getCitizenDetailsByStatus(citizenId);
    }

    @GetMapping("/citizens/status/{status}")
    public String fun4(@PathVariable String status) {
        List<Citizen> citi = citizenDAO.getAllCitizenDetailsByStatus(status);
        return "dashboard";
    }


}

