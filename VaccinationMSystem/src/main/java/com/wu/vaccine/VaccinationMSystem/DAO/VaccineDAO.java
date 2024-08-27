package com.wu.vaccine.VaccinationMSystem.DAO;

import com.wu.vaccine.VaccinationMSystem.entity.Citizen;
import com.wu.vaccine.VaccinationMSystem.entity.Dose;
import com.wu.vaccine.VaccinationMSystem.entity.Vaccine;

import java.util.List;

public interface VaccineDAO {
    List<Vaccine>getAllVaccineDetails();
    String getCertificateIdById(String citizenId);
    List<Dose> getDoseDetails(String citizenId);
    Vaccine getVaccineDetailsByID(String citizenId);
}

