package com.wu.vaccine.VaccinationMSystem.DAO;

import com.wu.vaccine.VaccinationMSystem.entity.Citizen;
import com.wu.vaccine.VaccinationMSystem.entity.Dose;
import com.wu.vaccine.VaccinationMSystem.entity.Vaccine;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

import static com.wu.vaccine.VaccinationMSystem.DAO.CitizenDAOImpl.is120DaysDifference;

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
        try {
            List<Vaccine> res = theQuery.getResultList();
            return res;
        } catch (Exception e) {
            return null;
        }

    }

    @Transactional
    @Override
    public void updateVaccineDetails(String citizenId) {
        LocalDate curr = LocalDate.now();
        Session ss = entityManager.unwrap(Session.class);
        Query theQuery = ss.createQuery("From Citizen where citizenId=:theid", Citizen.class);
        theQuery.setParameter("theid", citizenId);
        Citizen c = (Citizen) theQuery.getSingleResult();
        if (is120DaysDifference(curr, LocalDate.parse(c.getLast_vaccinated())))
            //throw exception
            c.setLast_vaccinated(curr.toString());
         // citizen updated;
        theQuery = ss.createQuery("From Vaccine where citizenId=:theid", Vaccine.class);
        theQuery.setParameter("theid", citizenId);
        try {
            Vaccine v = (Vaccine) theQuery.getSingleResult();
            if (v.getDose2Id().equals("NA")) {
                c.setVaccination_status("FULLY");

                Dose entry = new Dose(citizenId, "Shubhangi Kumari", curr.toString(), "Covishield", citizenId + "B");
                entityManager.merge(entry);
                //Dose(String citizenId, String doseGivenBy, String given_date,  String doseName, String doseId)
                v.setDose2Id(citizenId + "B");
            } else if (v.getDose3Id().equals("NA")) {
                c.setVaccination_status("BOOSTER");
                Dose entry = new Dose(citizenId, "Shubhangi Kumari", curr.toString(), "Covishield", citizenId + "C");
                entityManager.merge(entry);
                v.setDose3Id(citizenId + "C");
            }
            entityManager.merge(c);
            entityManager.merge(v);
        } catch (Exception e) {
            return;
        }
        ///vaccine updated;


    }


    @Override
    public String getCertificateIdById(String citizenId) {
        Session ss = entityManager.unwrap(Session.class);
        Query theQuery = ss.createQuery("From Vaccine", Vaccine.class);
        try {
            Vaccine res = (Vaccine) theQuery.getSingleResult();
            return res.getCertificateNo();
        } catch (Exception e) {
            return null;
        }

    }

    @Override
    public Vaccine getVaccineDetailsByID(String citizenId) {
        Session ss = entityManager.unwrap(Session.class);
        Query theQuery = ss.createQuery("From Vaccine where citizenId=:theid", Citizen.class);
        theQuery.setParameter("theid", citizenId);

        try {
            return (Vaccine) theQuery.getSingleResult();
        } catch (Exception e) {
            return null;
        }

    }
    @Transactional
    @Override
    public String deleteVaccineDetails(String citizenId) {
        Session ss = entityManager.unwrap(Session.class);
        Query theQuery = ss.createQuery("From Vaccine where citizenId=:theid", Citizen.class);
        theQuery.setParameter("theid", citizenId);
        Vaccine obj = (Vaccine) theQuery.getSingleResult();
        if(!obj.getDose3Id().equals("NA")){
           theQuery = ss.createQuery("From Citizen where citizenId=:theid", Citizen.class);
            theQuery.setParameter("theid", citizenId);
            Citizen obj2 = (Citizen) theQuery.getSingleResult();
            entityManager.remove(obj2);
            entityManager.remove(obj);
            theQuery = ss.createQuery("From Dose where citizenId=:theid", Citizen.class);
            theQuery.setParameter("theid", citizenId);
            List<Dose> obj3=theQuery.getResultList();
            for(Dose d:obj3)
                entityManager.remove(d);

            return "Details Deleted Successfully";
        }

        return "Operation Not Allowed";
    }
}

