package com.wu.vaccine.VaccinationMSystem.service;

import com.wu.vaccine.VaccinationMSystem.entity.Citizen;

import java.util.List;

public interface CitizenService {
    Citizen registerCitizen(Citizen citizen);
    Citizen getCitizenDetailsById(String citizenId);
    List<Citizen> getAllCitizenDetails();
    void deleteCitizenDetails(Citizen citizen);
    String getCitizenDetailsByStatus(String citizenId);
    List<Citizen> getAllCitizenDetailsByStatus(String status);
    boolean checkIfCitizenExist(String aadhar);
}
