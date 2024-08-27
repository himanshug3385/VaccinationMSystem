package com.wu.vaccine.VaccinationMSystem.DAO;

import com.wu.vaccine.VaccinationMSystem.entity.Citizen;
import com.wu.vaccine.VaccinationMSystem.entity.Dose;

import java.util.Date;

public interface DoseDAO {
    Dose getDoseDetailsByDoseId(String doesId);
    Dose getDoseDetailsByCitizenId(String citizenId);
    void deleteDoseByDoseId(String doseId);
    Citizen getCitizenDetailsByCitizenId(String citizenId);
}
