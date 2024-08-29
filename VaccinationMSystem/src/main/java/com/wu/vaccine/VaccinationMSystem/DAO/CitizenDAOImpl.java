package com.wu.vaccine.VaccinationMSystem.DAO;

import com.wu.vaccine.VaccinationMSystem.entity.Citizen;
import com.wu.vaccine.VaccinationMSystem.entity.Dose;
import com.wu.vaccine.VaccinationMSystem.entity.Vaccine;
import com.wu.vaccine.VaccinationMSystem.exception.CitizenNotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
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
        entityManager.merge(new Vaccine(citizen.getCitizenId(),citizen.getCitizenId(),citizen.getCitizenId()+"A","NA","NA","pune"));
        entityManager.merge(new Dose(citizen.getCitizenId(),"Shubhangi Kumari",currentDate.toString() ,"Covishield",citizen.getCitizenId()+"A"));
        return res;
    }
    
   //  get the citizen details by providing the citizen ID
    @Override
    public Citizen getCitizenDetailsById(String citizenId) {
        Session ss= entityManager.unwrap(Session.class);
            Query theQuery= ss.createQuery("From Citizen where citizenId=:theid",Citizen.class);
            theQuery.setParameter("theid",citizenId);
            Citizen cz = (Citizen) theQuery.getSingleResult();

            return cz ;


    }
    // get the List of All citizens who have registered for vaccination or have taken any Dose

    @Override
    public List<Citizen> getAllCitizenDetails() {
        Session ss= entityManager.unwrap(Session.class);
        Query theQuery= ss.createQuery("from Citizen",Citizen.class);
        try{
            List<Citizen> res= theQuery.getResultList();
            return res;
        }catch(Exception e){
            return null;
        }

    }
    // Updating the citizen vaccincation details while

//    // delete citizen Details - insuring he/she has taken two dose atleast
    @Transactional
    @Override
    public void deleteCitizenDetails(Citizen citizen) {
        Session ss= entityManager.unwrap(Session.class);
        Query theQuery= ss.createQuery("From Vaccine where citizenId=:theid",Citizen.class);
        theQuery.setParameter("theid",citizen.getCitizenId());
        try{
            Vaccine vacc= (Vaccine) theQuery.getSingleResult();
            if(vacc.getDose3Id().equals("NA"))
                //throw error
                entityManager.remove(citizen);
        }catch(Exception e){
            return ;
        }

    }
//    // Get the vaccination status of a citizen by its citizenId
    @Override
    public String getCitizenDetailsByStatus(String citizenId) {
        Session ss= entityManager.unwrap(Session.class);
        Query theQuery= ss.createQuery("From Citizen where citizenId=:x",Citizen.class);
        theQuery.setParameter("x",citizenId);
        try{
            Citizen res= (Citizen) theQuery.getSingleResult();
            return res.getVaccination_status();
        }catch(Exception e){
            return null;
        }

    }
//     // Get list of all citizen details by vaccination status
    @Override
    public List<Citizen> getAllCitizenDetailsByStatus(String status) {
        Session ss= entityManager.unwrap(Session.class);
        Query theQuery= ss.createQuery("From Citizen where vaccination_status=:x",Citizen.class);
        theQuery.setParameter("x",status);
        try{
            List<Citizen>res= theQuery.getResultList();
            return res;
        }catch(Exception e){
            return null;
        }


    }

    @Override
    public boolean checkIfCitizenExist(String aadhar) {
        Session ss= entityManager.unwrap(Session.class);
        Query theQuery= ss.createQuery("From Citizen where addhar_no=:x",Citizen.class);
        theQuery.setParameter("x",aadhar);
        Citizen res=null;
        try{
            res= (Citizen) theQuery.getSingleResult();
            return true;
        }
        catch(Exception e){
            return false;
        }

        //System.out.println(res);

    }
    public static boolean is120DaysDifference(LocalDate date1, LocalDate date2) {
        long daysBetween = ChronoUnit.DAYS.between(date1, date2);
        return Math.abs(daysBetween) >= 120;
    }
}
