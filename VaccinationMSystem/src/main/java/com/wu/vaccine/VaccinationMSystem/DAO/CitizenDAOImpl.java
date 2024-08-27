package com.wu.vaccine.VaccinationMSystem.DAO;

import com.wu.vaccine.VaccinationMSystem.entity.Citizen;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.hibernate.Session;

import java.util.List;

public class CitizenDAOImpl implements CitizenDAO{
    private final EntityManager entityManager;
    public CitizenDAOImpl(EntityManager ss) {
        this.entityManager=ss;
    }
    @Override
    public Citizen registerCitizen(Citizen citizen) {
        Citizen res=  entityManager.merge(citizen);
        return res;
    }

    @Override
    public Citizen getCitizenDetailsById(int citizenId) {
        Session ss= entityManager.unwrap(Session.class);
        Query theQuery= ss.createQuery("From Customer where id=:theid",Citizen.class);
        theQuery.setParameter("theid",citizenId);
        return (Citizen) theQuery.getSingleResult();
    }

    @Override
    public List<Citizen> getAllCitizenDetails() {
        Session ss= entityManager.unwrap(Session.class);
        Query theQuery= ss.createQuery("From Customer",Citizen.class);
        List<Citizen> res= theQuery.getResultList();
        return res;
    }

    @Override
    public Citizen upDateCitizenDetails(Citizen citizen) {
        Citizen res=  entityManager.merge(citizen);
        return res;
    }

    @Override
    public void deleteCitizenDetails(Citizen citizen) {
        entityManager.remove(citizen);
        return;
    }

    @Override
    public String getCitizenDetailsByStatus(String citizenId) {
        Session ss= entityManager.unwrap(Session.class);
        Query theQuery= ss.createQuery("From Customer where id=:theid",Citizen.class);
        theQuery.setParameter("theid",citizenId);
        Citizen res= (Citizen) theQuery.getSingleResult();
        return res.getVaccination_status();
    }

    @Override
    public List<Citizen> getAllCitizenDetailsByStatus(String status) {
        Session ss= entityManager.unwrap(Session.class);
        Query theQuery= ss.createQuery("From Customer where vaccination_status=:theid",Citizen.class);
        theQuery.setParameter("theid",status);
        List<Citizen>res= theQuery.getResultList();
        return res;

    }
}
