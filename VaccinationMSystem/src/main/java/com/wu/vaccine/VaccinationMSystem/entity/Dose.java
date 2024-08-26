package com.wu.vaccine.VaccinationMSystem.entity;

import java.util.Date;

public class Dose {
    private int doseId;
    private String citizenId;
    private String doseName;
    private String doseGivenBy;
    private Date  given_date;
    private String merchant;
    public Dose() {
    }

    public String getMerchant() {
        return merchant;
    }

    public void setMerchant(String merchant) {
        this.merchant = merchant;
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

    public Dose(String citizenId, String doseGivenBy, Date given_date, String merchant, String doseName, int doseId) {
        this.citizenId = citizenId;
        this.doseGivenBy = doseGivenBy;
        this.given_date = given_date;
        this.merchant = merchant;
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
                ", merchant='" + merchant + '\'' +
                '}';
    }
}
