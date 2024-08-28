package com.wu.vaccine.VaccinationMSystem.service;

import com.wu.vaccine.VaccinationMSystem.entity.Dose;

import java.util.List;

public interface DoseService {
    Dose getDoseDetailsByDoseId(String doesId);
    List<Dose> getDoseDetailsByCitizenId(String citizenId);
    void deleteDoseByDoseId(String doseId);
}
