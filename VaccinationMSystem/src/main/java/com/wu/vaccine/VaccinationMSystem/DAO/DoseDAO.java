package com.wu.vaccine.VaccinationMSystem.DAO;

import com.wu.vaccine.VaccinationMSystem.entity.Citizen;
import com.wu.vaccine.VaccinationMSystem.entity.Dose;

import java.util.Date;
import java.util.List;

public interface DoseDAO {
    Dose getDoseDetailsByDoseId(String doesId);
    List<Dose> getDoseDetailsByCitizenId(String citizenId);
    void deleteDoseByDoseId(String doseId);
    List<Dose> getDoseDetails();


}
