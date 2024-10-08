package com.wu.vaccine.VaccinationMSystem.DAO;

import com.wu.vaccine.VaccinationMSystem.entity.Citizen;
import com.wu.vaccine.VaccinationMSystem.entity.Dose;
import com.wu.vaccine.VaccinationMSystem.entity.Vaccine;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.hibernate.Session;

import java.util.List;

import com.wu.vaccine.VaccinationMSystem.entity.Citizen;
import com.wu.vaccine.VaccinationMSystem.entity.Dose;
import com.wu.vaccine.VaccinationMSystem.entity.Vaccine;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DoseDAOImpl implements DoseDAO{
    private final EntityManager entityManager;
    public DoseDAOImpl(EntityManager theEntityManager){
        this.entityManager=theEntityManager;
    }

    @Override
    public Dose getDoseDetailsByDoseId(String doseId) {
        Session ss= entityManager.unwrap(Session.class);
        Query theQuery= ss.createQuery("From Dose where doseId=:theId", Vaccine.class);
        theQuery.setParameter("theId",doseId);
        try{
            Dose res= (Dose)theQuery.getSingleResult();
            return res;
        }catch(Exception e){
            return null;
        }


    }

    @Override
    public List<Dose> getDoseDetailsByCitizenId(String citizenId) {
        Session ss= entityManager.unwrap(Session.class);
        Query theQuery= ss.createQuery("From Dose where citizenId=:theId", Vaccine.class);
        theQuery.setParameter("theId",citizenId);
        try{
            List<Dose> res= theQuery.getResultList();
            return res;
        }catch(Exception e){
            return null;
        }

    }
    @Transactional
    @Override
    public void deleteDoseByDoseId(String doseId) {
        Session ss= entityManager.unwrap(Session.class);
        Query theQuery = ss.createQuery(" DELETE From Dose where doseId=:theId", Vaccine.class);
        theQuery.setParameter("theId",doseId);
        int result = theQuery.executeUpdate();
        if (result > 0) {
            System.out.println("Dose with doseId " + doseId + " deleted successfully.");
        } else {
            System.out.println("No Dose record found with doseId: " + doseId);
        }
    }

    @Override
    public List<Dose> getDoseDetails() {
        Session ss= entityManager.unwrap(Session.class);
        Query theQuery= ss.createQuery("From Dose ", Vaccine.class);
        return theQuery.getResultList();
    }


}



