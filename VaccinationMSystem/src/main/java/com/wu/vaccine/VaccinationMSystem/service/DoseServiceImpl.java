package com.wu.vaccine.VaccinationMSystem.service;

import com.wu.vaccine.VaccinationMSystem.DAO.DoseDAO;
import com.wu.vaccine.VaccinationMSystem.entity.Dose;

import java.util.List;

public class DoseServiceImpl implements DoseService{
    private DoseDAO doseDAO;
    public DoseServiceImpl(DoseDAO thedoseDAO){
        this.doseDAO=thedoseDAO;
    }
    @Override
    public Dose getDoseDetailsByDoseId(String doesId) {
        return doseDAO.getDoseDetailsByDoseId(doesId);
    }

    @Override
    public List<Dose> getDoseDetailsByCitizenId(String citizenId) {
        return doseDAO.getDoseDetailsByCitizenId(citizenId);
    }

    @Override
    public void deleteDoseByDoseId(String doseId) {
           doseDAO.deleteDoseByDoseId(doseId);
    }
}
