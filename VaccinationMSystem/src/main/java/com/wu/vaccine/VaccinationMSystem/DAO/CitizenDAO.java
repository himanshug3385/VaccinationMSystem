package com.wu.vaccine.VaccinationMSystem.DAO;

import com.wu.vaccine.VaccinationMSystem.entity.Citizen;

import java.util.List;

public interface CitizenDAO {
    Citizen registerCitizen(Citizen citizen);
    Citizen getCitizenDetailsById(int citizenId);
    List<Citizen> getAllCitizenDetails();
    Citizen upDateCitizenDetails(Citizen citizen);
    void deleteCitizenDetails(Citizen citizen);
    String getCitizenDetailsByStatus(String citizenId);
    List<Citizen> getAllCitizenDetailsByStatus(String status);
}
