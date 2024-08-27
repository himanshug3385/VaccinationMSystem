package com.wu.vaccine.VaccinationMSystem.entity;

import jakarta.persistence.*;

import java.util.Date;
@Entity
@Table(name="Dose")
public class Dose {
    @Id
    @Column(name="Dose_ID")
    private String doseId;
    @Column(name="Citizen_ID")
    private String citizenId;
    @Column(name="Dose_Name")
    private String doseName;
    @Column(name="Vaccinated_By")
    private String doseGivenBy;
    @Column(name="Dose_Date")
    private String  given_date;

    public Dose() {
    }


    public String getGiven_date() {
        return given_date;
    }

    public void setGiven_date(String given_date) {
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

    public String getDoseId() {
        return doseId;
    }

    public void setDoseId(String doseId) {
        this.doseId = doseId;
    }

    public Dose(String citizenId, String doseGivenBy, String given_date,  String doseName, String doseId) {
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
