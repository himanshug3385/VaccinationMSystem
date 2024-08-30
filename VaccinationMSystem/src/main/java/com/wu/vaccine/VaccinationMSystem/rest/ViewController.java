package com.wu.vaccine.VaccinationMSystem.rest;

import com.wu.vaccine.VaccinationMSystem.DAO.CitizenDAO;
import com.wu.vaccine.VaccinationMSystem.DAO.DoseDAO;
import com.wu.vaccine.VaccinationMSystem.DAO.VaccineDAO;
import com.wu.vaccine.VaccinationMSystem.entity.Citizen;
import com.wu.vaccine.VaccinationMSystem.entity.Dose;
import com.wu.vaccine.VaccinationMSystem.entity.Vaccine;
import com.wu.vaccine.VaccinationMSystem.exception.CitizenAlreadyExistException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/view")
public class ViewController {
    private CitizenDAO citizenDAO;
    private VaccineDAO vaccineDAO;
    private DoseDAO doseDAO;
    public ViewController(CitizenDAO citizenDAO, VaccineDAO vaccineDAO, DoseDAO doseDAO){
        this.citizenDAO=citizenDAO;
        this.doseDAO=doseDAO;
        this.vaccineDAO=vaccineDAO;
    }
    @GetMapping("/citizen")
    public String getCitizens(Model theModel) {
        List<Citizen> res = citizenDAO.getAllCitizenDetails();
        theModel.addAttribute("citizens",res);
        return "citizen";
    }

    @GetMapping("/citizen/{citizenId}")
    public String fun2(@PathVariable String citizenId,Model model) {
        Citizen citizen = citizenDAO.getCitizenDetailsById(citizenId);
        model.addAttribute("citizen",citizen);
        return "register";
    }

    @GetMapping("/citizen/registeration")
    public String showRegistrationForm(Model model) {
        model.addAttribute("citizen",new Citizen());
        return "register";
    }


    //api/citizen/register
    @PostMapping("/citizen/register")
    public String addcitizen(@ModelAttribute("citizen") Citizen thecitizen) {
//        if(citizenDAO.checkIfCitizenExist(thecitizen.getAddhar_no()))
//            throw new CitizenAlreadyExistException("Sorry! You are already Exists!!");
        LocalDate currentDate = LocalDate.now();
        thecitizen.setLast_vaccinated(currentDate.toString());
        thecitizen.setCitizenId(thecitizen.getAddhar_no());

        citizenDAO.registerCitizen(thecitizen);
        return "redirect:/view";
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
   ///vaccine Controller Apis

    @GetMapping("")
    public String vaccineDetails(Model model) {

        List<Vaccine> res = vaccineDAO.getAllVaccineDetails();
        model.addAttribute("vaccineData", res);
        return "dashboard";

    }

    @GetMapping("/vaccine/certificate/{citizenId}")

    public String certificateById(@PathVariable String citizenId) {
        String vacc = vaccineDAO.getCertificateIdById(citizenId);
        return vacc;

    }

    @PostMapping("/vaccine/update")
    public String takeDose(@ModelAttribute("vaccine") Vaccine vaccine) {
        vaccineDAO.updateVaccineDetails(vaccine.getCitizenId());
        return "redirect:/view";

    }

    // /api/vaccine/update/{citizenId}(citizenId=${vaccine.citizenId})
    @GetMapping("/vaccine/update/{citizenId}")
    public String funf(@PathVariable String citizenId, Model model) {
        Vaccine vaccine = vaccineDAO.getVaccineDetailsByID(citizenId);
        List<Dose> doses = doseDAO.getDoseDetailsByCitizenId(citizenId);
        model.addAttribute("vaccines", vaccine);
        model.addAttribute("doses", doses);

        System.out.println(doses);
        return "TakeDose";
    }

    @GetMapping("/vaccine/{citizenId}")
    public Vaccine vaccineDetailsById(@PathVariable String citizenId) {

        Vaccine vacc = vaccineDAO.getVaccineDetailsByID(citizenId);

        return vacc;

    }

    ///api/vaccine/delete(citizenId=${vaccine.citizenId})}
    //@{/api/vaccine/delete/{citizenId}(citizenId=${vaccine.citizenId})}
    @GetMapping("/vaccine/delete/{citizenId}")
    public String deleteVaccineDetails(@PathVariable(name = "citizenId") String citizendId, Model model) {
        String result = vaccineDAO.deleteVaccineDetails(citizendId);
        if(result.equals("Operation Not Allowed")) {
            model.addAttribute("alertMessage", "Operation Not Allowed");
            return "404Page";
        }
        return "redirect:/view";
    }

    // Dose Controller

    @GetMapping("/dose/{citizenId}")
    public List<Dose> DoseDetailsByCitizenId(@PathVariable String citizenId){
        List<Dose>res= doseDAO.getDoseDetailsByCitizenId(citizenId);

        return res;
    }
    @GetMapping("/doses")
    public String fdljf(Model model){
        List<Dose> res =doseDAO.getDoseDetails();
        model.addAttribute("doses",res);
        return "dose";
    }

    @GetMapping("/dose/details/{doseId}")
    public String DoseDetailsByDoseId(@PathVariable String doseId, Model model){
        Dose dose = doseDAO.getDoseDetailsByDoseId(doseId);
        model.addAttribute("doses",dose);
        return "dose";
    }

    @DeleteMapping("/dose/{doseId}")
    public String deleteDose(@PathVariable String doseId){
        doseDAO.deleteDoseByDoseId(doseId);
        return "dose details are deleted";
    }
}
