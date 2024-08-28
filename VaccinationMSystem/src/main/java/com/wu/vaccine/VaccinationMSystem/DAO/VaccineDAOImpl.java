package com.wu.vaccine.VaccinationMSystem.DAO;

import com.wu.vaccine.VaccinationMSystem.entity.Citizen;
import com.wu.vaccine.VaccinationMSystem.entity.Dose;
import com.wu.vaccine.VaccinationMSystem.entity.Vaccine;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class VaccineDAOImpl implements VaccineDAO{
    private final EntityManager entityManager;
    public VaccineDAOImpl(EntityManager ss) {
        this.entityManager=ss;
    }
    @Override
    public List<Vaccine> getAllVaccineDetails() {
        Session ss= entityManager.unwrap(Session.class);
        Query theQuery= ss.createQuery("From Vaccine",Vaccine.class);
        List<Vaccine> res= theQuery.getResultList();
        return res;
    }


    @Override
    public String getCertificateIdById(String citizenId) {
        Session ss= entityManager.unwrap(Session.class);
        Query theQuery= ss.createQuery("From Vaccine",Vaccine.class);
        Vaccine res= (Vaccine) theQuery.getSingleResult();
        return res.getCertificateNo();
    }

//    @Override
//    public List<Dose> getDoseDetails(String citizenId) {
//        Session ss= entityManager.unwrap(Session.class);
//        Query theQuery= ss.createQuery("From Customer",Vaccine.class);
//       List<Dose> res = List.of();
//       return res;
//    }

    @Override
    public Vaccine getVaccineDetailsByID(String citizenId) {
        Session ss= entityManager.unwrap(Session.class);
        Query theQuery= ss.createQuery("From Vaccine where citizenId=:theid",Citizen.class);
        theQuery.setParameter("theid",citizenId);
        return (Vaccine) theQuery.getSingleResult();
    }
}

