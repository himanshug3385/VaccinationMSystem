package com.wu.vaccine.VaccinationMSystem.service;

import com.wu.vaccine.VaccinationMSystem.entity.Citizen;

import java.util.List;

public interface CitizenService {
    Citizen registerCitizen(Citizen citizen);
    Citizen getCitizenDetailsById(int citizenId);
    List<Citizen> getAllCitizenDetails();
    Citizen upDateCitizenDetails(Citizen citizen);
    void deleteCitizenDetails(Citizen citizen);
    List<Citizen> getCitizenDetailsByStatus(String status);
}
