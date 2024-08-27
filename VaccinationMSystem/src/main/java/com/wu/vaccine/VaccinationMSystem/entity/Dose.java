package com.wu.vaccine.VaccinationMSystem.entity;

import jakarta.persistence.*;

import java.util.Date;
@Entity
@Table(name="Dose")
public class Dose {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Dose_ID")
    private int doseId;
    @Column(name="Citizen_ID")
    private String citizenId;
    @Column(name="Dose_Name")
    private String doseName;
    @Column(name="Vaccinated_By")
    private String doseGivenBy;
    @Column(name="Dose_Date")
    private Date  given_date;

    public Dose() {
    }


    public Date getGiven_date() {
        return given_date;
    }

    public void setGiven_date(Date given_date) {
        this.given_date = given_date;
    }

    public String getDoseGivenBy() {
        return doseGivenBy;
    }

    public void setDoseGivenBy(String doseGivenBy) {
        this.doseGivenBy = doseGivenBy;
    }

    public String getDoseName() {
        return doseName;
    }

    public void setDoseName(String doseName) {
        this.doseName = doseName;
    }

    public String getCitizenId() {
        return citizenId;
    }

    public void setCitizenId(String citizenId) {
        this.citizenId = citizenId;
    }

    public int getDoseId() {
        return doseId;
    }

    public void setDoseId(int doseId) {
        this.doseId = doseId;
    }

    public Dose(String citizenId, String doseGivenBy, Date given_date,  String doseName, int doseId) {
        this.citizenId = citizenId;
        this.doseGivenBy = doseGivenBy;
        this.given_date = given_date;

        this.doseName = doseName;
        this.doseId = doseId;
    }

    @Override
    public String toString() {
        return "Dose{" +
                "doseId=" + doseId +
                ", citizenId='" + citizenId + '\'' +
                ", doseName='" + doseName + '\'' +
                ", doseGivenBy='" + doseGivenBy + '\'' +
                ", given_date=" + given_date +

                '}';
    }
}
