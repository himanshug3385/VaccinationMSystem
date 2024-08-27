package com.wu.vaccine.VaccinationMSystem.DAO;

import com.wu.vaccine.VaccinationMSystem.entity.Citizen;
import com.wu.vaccine.VaccinationMSystem.entity.Dose;
import com.wu.vaccine.VaccinationMSystem.entity.Vaccine;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.hibernate.Session;

import java.util.List;

public class DoseDAOImpl implements DoseDAO{
    private final EntityManager entityManager;
    public DoseDAOImpl(EntityManager theEntityManager){
        this.entityManager=theEntityManager;
    }
    @Override
    public Dose getDoseDetailsByDoseId(String doseId) {
        Session ss= entityManager.unwrap(Session.class);
        Query theQuery= ss.createQuery("From Dose where doseId:theId", Vaccine.class);
        theQuery.setParameter("theId",doseId);
        Dose res= (Dose)theQuery.getSingleResult();
        return res;

    }

    @Override
    public Dose getDoseDetailsByCitizenId(String citizenId) {
        Session ss= entityManager.unwrap(Session.class);
        Query theQuery= ss.createQuery("From Dose where citizenId:theId", Vaccine.class);
        theQuery.setParameter("theId",citizenId);
        Dose res= (Dose)theQuery.getSingleResult();
        return res;
    }

    @Override
    public void deleteDoseByDoseId(String doseId) {

    }

    @Override
    public Citizen getCitizenDetailsByCitizenId(String citizenId) {
        return null;
    }
}
