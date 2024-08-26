package com.vaccine.VaccinationMSystem.DAO;

import com.vaccine.VaccinationMSystem.entity.Citizen;

import java.util.List;

public interface CitizenDAO {
    void registerCitizen(Citizen citizen);
    Citizen getCitizenDetailsById(int citizenId);
    List<Citizen> getAllCitizenDetails();
    void upDateCitizenDetails(Citizen citizen);
    void deleteCitizenDetails(Citizen citizen);
    List<Citizen> getCitizenDetailsByStatus();
}
