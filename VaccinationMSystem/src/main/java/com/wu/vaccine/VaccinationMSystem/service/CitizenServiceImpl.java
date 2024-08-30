package com.wu.vaccine.VaccinationMSystem.service;

import com.wu.vaccine.VaccinationMSystem.DAO.CitizenDAO;
import com.wu.vaccine.VaccinationMSystem.entity.Citizen;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CitizenServiceImpl implements CitizenService {
    private CitizenDAO citizenDAO;
    public CitizenServiceImpl(CitizenDAO thecitizenDAO){
        this.citizenDAO=thecitizenDAO;
    }
    @Override
    public Citizen registerCitizen(Citizen citizen) {
        return citizenDAO.registerCitizen(citizen);
    }

    @Override
    public Citizen getCitizenDetailsById(String citizenId) {
        return citizenDAO.getCitizenDetailsById(citizenId);
    }

    @Override
    public List<Citizen> getAllCitizenDetails() {
        return citizenDAO.getAllCitizenDetails();
    }

    @Override
    public void deleteCitizenDetails(Citizen citizen) {
        citizenDAO.deleteCitizenDetails(citizen);
    }

    @Override
    public String getCitizenDetailsByStatus(String citizenId) {
        return citizenDAO.getCitizenDetailsByStatus(citizenId);
    }

    @Override
    public List<Citizen> getAllCitizenDetailsByStatus(String status) {
        return citizenDAO.getAllCitizenDetailsByStatus(status);
    }

    @Override
    public boolean checkIfCitizenExist(String aadhar) {
        return citizenDAO.checkIfCitizenExist(aadhar);
    }
}