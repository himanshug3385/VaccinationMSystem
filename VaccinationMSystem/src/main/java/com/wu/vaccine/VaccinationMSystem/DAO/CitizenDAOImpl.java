package com.wu.vaccine.VaccinationMSystem.DAO;

import com.wu.vaccine.VaccinationMSystem.entity.Citizen;
import com.wu.vaccine.VaccinationMSystem.entity.Dose;
import com.wu.vaccine.VaccinationMSystem.entity.Vaccine;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Repository
public class CitizenDAOImpl implements CitizenDAO{
    private  EntityManager entityManager;
    public CitizenDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }


    // register the citizen vaccination details while taking first dose
    @Transactional
    @Override
    public Citizen registerCitizen(Citizen citizen) {

        Citizen res=  entityManager.merge(citizen);
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = currentDate.format(formatter);
        entityManager.merge(new Vaccine(citizen.getCitizenId()+formattedDate,citizen.getCitizenId(),citizen.getCitizenId()+"A","NA","NA","pune"));
        entityManager.merge(new Dose(citizen.getCitizenId(),"Shubhangi Kumari", formattedDate,"Covishield",citizen.getCitizenId()+"A"));
        return res;
    }
    
   //  get the citizen details by providing the citizen ID
    @Override
    public Citizen getCitizenDetailsById(String citizenId) {
        Session ss= entityManager.unwrap(Session.class);
        Query theQuery= ss.createQuery("From Citizen where citizenId=:theid",Citizen.class);
        theQuery.setParameter("theid",citizenId);
        return (Citizen) theQuery.getSingleResult();
    }
    // get the List of All citizens who have registered for vaccination or have taken any Dose
   @Transactional
    @Override
    public List<Citizen> getAllCitizenDetails() {
        Session ss= entityManager.unwrap(Session.class);
        Query theQuery= ss.createQuery("from Citizen",Citizen.class);
        List<Citizen> res= theQuery.getResultList();
        return res;
    }
    // Updating the citizen vaccincation details while

//    // delete citizen Details - insuring he/she has taken two dose atleast
    @Override
    public void deleteCitizenDetails(Citizen citizen) {
        Session ss= entityManager.unwrap(Session.class);
        Query theQuery= ss.createQuery("From Citizen where citizenId=:x",Citizen.class);
        theQuery.setParameter("x",citizen.getCitizenId());
        Citizen res= (Citizen) theQuery.getSingleResult();

        entityManager.remove(citizen);
        return;
    }
//    // Get the vaccination status of a citizen by its citizenId
    @Override
    public String getCitizenDetailsByStatus(String citizenId) {
        Session ss= entityManager.unwrap(Session.class);
        Query theQuery= ss.createQuery("From Citizen where citizenId=:x",Citizen.class);
        theQuery.setParameter("x",citizenId);
        Citizen res= (Citizen) theQuery.getSingleResult();
        return res.getVaccination_status();
    }
//     // Get list of all citizen details by vaccination status
    @Override
    public List<Citizen> getAllCitizenDetailsByStatus(String status) {
        Session ss= entityManager.unwrap(Session.class);
        Query theQuery= ss.createQuery("From Citizen where vaccination_status=:x",Citizen.class);
        theQuery.setParameter("x",status);
        List<Citizen>res= theQuery.getResultList();
        return res;

    }

    @Override
    public boolean checkIfCitizenExist(String aadhar) {
        Session ss= entityManager.unwrap(Session.class);
        Query theQuery= ss.createQuery("From Citizen where addhar_no=:x",Citizen.class);
        theQuery.setParameter("x",aadhar);
        Citizen res= (Citizen) theQuery.getSingleResult();
        return res!=null;

    }
}
