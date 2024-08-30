package com.wu.vaccine.VaccinationMSystem.service;

import com.wu.vaccine.VaccinationMSystem.DAO.VaccineDAO;
import com.wu.vaccine.VaccinationMSystem.DAO.VaccineDAOImpl;
import com.wu.vaccine.VaccinationMSystem.entity.Dose;
import com.wu.vaccine.VaccinationMSystem.entity.Vaccine;

import java.util.List;

public class VaccineServiceImpl implements VaccineService {
     private VaccineDAO vaccineDAO;
     public VaccineServiceImpl(VaccineDAO thevaccineDAO){
         this.vaccineDAO=thevaccineDAO;
     }
    @Override
    public List<Vaccine> getAllVaccineDetails() {
        return vaccineDAO.getAllVaccineDetails();
    }

    @Override
    public void updateVaccineDetails(String citizenId) {
         vaccineDAO.updateVaccineDetails(citizenId);
    }

    @Override
    public String getCertificateIdById(String citizenId) {
        return vaccineDAO.getCertificateIdById(citizenId);
    }

    @Override
    public Vaccine getVaccineDetailsByID(String citizenId) {
        return vaccineDAO.getVaccineDetailsByID(citizenId);
    }
}
