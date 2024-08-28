package com.wu.vaccine.VaccinationMSystem.DAO;

import com.wu.vaccine.VaccinationMSystem.entity.Citizen;
import com.wu.vaccine.VaccinationMSystem.entity.Dose;
import com.wu.vaccine.VaccinationMSystem.entity.Vaccine;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class VaccineDAOImpl implements VaccineDAO {
    private final EntityManager entityManager;

    public VaccineDAOImpl(EntityManager ss) {
        this.entityManager = ss;
    }

    @Override
    public List<Vaccine> getAllVaccineDetails() {
        Session ss = entityManager.unwrap(Session.class);
        Query theQuery = ss.createQuery("From Vaccine", Vaccine.class);
        List<Vaccine> res = theQuery.getResultList();
        return res;
    }

    @Override
    public void updateVaccineDetails(String citizenId) {
        Session ss = entityManager.unwrap(Session.class);
        Query theQuery = ss.createQuery("From Citizen where citizenId=:theid", Citizen.class);
        theQuery.setParameter("theid", citizenId);
        Citizen c = (Citizen) theQuery.getSingleResult();
        LocalDate curr = LocalDate.now();
        c.setLast_vaccinated(curr.toString());
        entityManager.merge(c);  // citizen updated;
        theQuery = ss.createQuery("From Vaccine where citizenId=:theid", Vaccine.class);
        theQuery.setParameter("theid", citizenId);
        Vaccine v = (Vaccine) theQuery.getSingleResult();
        if (v.getDose2Id().equals("NA")) {
            Dose entry= new Dose(citizenId,"Shubhangi Kumari",curr.toString(),"Covishield",citizenId+"B");
            entityManager.merge(entry);
            //Dose(String citizenId, String doseGivenBy, String given_date,  String doseName, String doseId)
            v.setDose2Id(citizenId + "B");
        } else if (v.getDose3Id().equals("NA")) {
            Dose entry= new Dose(citizenId,"Shubhangi Kumari",curr.toString(),"Covishield",citizenId+"C");
            entityManager.merge(entry);
            v.setDose3Id(citizenId + "C");
        }
        entityManager.merge(v);  ///vaccine updated;


    }


    @Override
    public String getCertificateIdById(String citizenId) {
        Session ss = entityManager.unwrap(Session.class);
        Query theQuery = ss.createQuery("From Vaccine", Vaccine.class);
        Vaccine res = (Vaccine) theQuery.getSingleResult();
        return res.getCertificateNo();
    }

    @Override
    public Vaccine getVaccineDetailsByID(String citizenId) {
        Session ss = entityManager.unwrap(Session.class);
        Query theQuery = ss.createQuery("From Vaccine where citizenId=:theid", Citizen.class);
        theQuery.setParameter("theid", citizenId);
        return (Vaccine) theQuery.getSingleResult();
    }
}

