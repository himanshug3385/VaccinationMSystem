package com.wu.vaccine.VaccinationMSystem.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Vaccine")
public class Vaccine {
    @Column(name = "Certificate_No")
    private String certificateNo;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Citizen_ID")
    private String citizenId;
    @Column(name = "Dose1_ID")
    private int dose1Id;
    @Column(name = "Dose2_ID")
    private int dose2Id;
    @Column(name = "Dose3_ID")
    private int dose3Id;
    @Column(name = "Vaccination_Address")
    private String vacc_address;

    public Vaccine() {
    }

    public Vaccine(String certificateNo, String citizenId, int dose1Id, int dose2Id, int dose3Id, String vacc_address) {
        this.certificateNo = certificateNo;
        this.citizenId = citizenId;
        this.dose1Id = dose1Id;
        this.dose2Id = dose2Id;
        this.dose3Id = dose3Id;
        this.vacc_address = vacc_address;
    }

    public String getCertificateNo() {
        return certificateNo;
    }

    public void setCertificateNo(String certificateNo) {
        this.certificateNo = certificateNo;
    }

    public String getCitizenId() {
        return citizenId;
    }

    public void setCitizenId(String citizenId) {
        this.citizenId = citizenId;
    }

    public int getDose1Id() {
        return dose1Id;
    }

    public void setDose1Id(int dose1Id) {
        this.dose1Id = dose1Id;
    }

    public int getDose2Id() {
        return dose2Id;
    }

    public void setDose2Id(int dose2Id) {
        this.dose2Id = dose2Id;
    }

    public int getDose3Id() {
        return dose3Id;
    }

    public void setDose3Id(int dose3Id) {
        this.dose3Id = dose3Id;
    }

    public String getVacc_address() {
        return vacc_address;
    }

    public void setVacc_address(String vacc_address) {
        this.vacc_address = vacc_address;
    }

    @Override
    public String toString() {
        return "Vaccine{" +
                "certificateNo='" + certificateNo + '\'' +
                ", citizenId='" + citizenId + '\'' +
                ", dose1Id=" + dose1Id +
                ", dose2Id=" + dose2Id +
                ", dose3Id=" + dose3Id +
                ", vacc_address='" + vacc_address + '\'' +
                '}';
    }
}
