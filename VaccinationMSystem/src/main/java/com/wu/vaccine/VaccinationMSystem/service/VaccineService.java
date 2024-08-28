package com.wu.vaccine.VaccinationMSystem.service;

import com.wu.vaccine.VaccinationMSystem.entity.Dose;
import com.wu.vaccine.VaccinationMSystem.entity.Vaccine;

import java.util.List;

public interface VaccineService {
    List<Vaccine>getAllVaccineDetails();
    void updateVaccineDetails(String citizenId);
    String getCertificateIdById(String citizenId);
    Vaccine getVaccineDetailsByID(String citizenId);
}
